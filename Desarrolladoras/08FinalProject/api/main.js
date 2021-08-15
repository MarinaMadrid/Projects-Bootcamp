const app = require('./app');

// Defining the port on which the application will listen
const port = 3000;

// Starting the listening service
app.listen(port, () => {
    console.log('Escuchando en http://localhost:' + port);
});
