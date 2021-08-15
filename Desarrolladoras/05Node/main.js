const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost/AgendaDB';
let agendaDB;
MongoClient.connect(url, function (err, db) {

    if (err) {
        console.log("Error conectando mongo");
        throw err;
    }

    agendaDB = db.db("AgendaDB")

});

// Requiring the http interface
const http = require('http');

const querystring = require('querystring')

// Defining the port to use
const port = 3000;

// Creating the server and defining the response that is given to the requests
const server = http.createServer((request, response) => {
    // Extracting the request's content
    const { headers, method, url } = request;
    console.log('headers: ', headers);
    console.log('method: ', method);
    console.log('url: ', url);

    let body = [];
    let raw = ""

    request.on("data", (data) => {
        raw += data
    })
    request.on('end', () => {
        body = querystring.decode(raw);
        console.log(body)
        let { name, phone } = body;

        agendaDB.collection('User').insertOne({
            name: name,
            phone: phone
        })

        agendaDB.collection("User").find().toArray(function (err, docs) {
            if (err) {
                console.log(err);
                response.statusCode = 500;
                response.end(err)
            }

            // HTTP status code that is returned
            response.statusCode = 200;

            // Response headers, plain text
            response.setHeader('Content-Type', 'text/plain');

            // The request's content
            response.end(JSON.stringify(docs));
        });

    })
})

//Running the service to wait for requests
server.listen(port, () => {
    console.log('Servidor ejecutándose...');
    console.log('Abrir en un navegador http://localhost:3000');
});

