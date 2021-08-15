// Creating the MongoDB client
var MongoClient = require('mongodb').MongoClient;

// Variable to store the connection
var db = null;

// Function to connect to the database
module.exports.connect = function (url, callback) {

    // If it is already connected, it won't reconnect
    if (db) {
        return callback();
    }

    // Creating an instance of the MongoDB client
    const client = new MongoClient(url, { useNewUrlParser: true });

    // Connecting the client to the server
    client.connect(function (err, result) {
        if (err) {
            return callback(err);
        }
        console.log("Conectado a BD");
        db = result;
        callback();
    });
};

// Function to close the connection with the database
module.exports.close = function (callback) {
    if (db) {
        db.close(function (err, result) {
            console.log("Desconectado de BD");
            db = null;
            callback(err);
        });
    }
};

// Creating a function for getting the MongoDB client that is connected to database 
module.exports.get = function () {
    return db;
}