// Including the file with the definition of the DB
var db = require('../db');
var mongodb = require('mongodb');

// Conecting with the DB
db.connect('mongodb://localhost:27017', function (err) {
    if (err) {
        throw ('Fallo en la conexión con la BD');
    }
});

// Displaying all users
module.exports.users_list = function (req, res, next) {
    // If the object is null, the connection has not been established
    if (db.get() === null) {
        next(new Error('La conexión no está establecida'));
        return;
    }

    // Retrieving data from database in array format
    db.get().db('apidb').collection('users').find().toArray(function
    (err, result) {
        // If there is an error, it will send the error to the next function
        if (err) {
            next ( new Error('Fallo en la conexión con la BD') );
            return;
        } else {
            // If everything is fine, it will return the result to the client
            res.send(result);
        }
    });
};

// Creating a user
module.exports.users_create = function (req, res, next) {

    if (db.get() === null) {
        next(new Error('La conexión no está establecida'));
        return;
    }
    
    const user = {};
    user.name = req.body.name;
    user.surnames = req.body.surnames;
    user.age = req.body.age;
    user.dni = req.body.dni;
    user.birthday = req.body.birthday;
    user.favouriteColour = req.body.favouriteColour;
    user.gender = req.body.gender;

    //Inserting a document
    db.get().db('apidb').collection('users').insertOne(user, function
    (err, result) {
        // If there is an error, it will send the error to the next function
        if (err) {
            next(new Error('Fallo en la conexión con la BD'));
            return;
        } else {
            // If everything is fine, it will return the result to the client
            res.send(result.ops[0]._id);
        }
    });
};

// Updating users
module.exports.users_update_one = function (req, res, next) {
    if (db.get() === null) {
        next(new Error('La conexión no está establecida'));
        return;
    }

    const filter = {_id: new mongodb.ObjectID(req.params.id)};
    const update = {$set: {
        name: req.body.name, 
        surnames: req.body.surnames,
        age: req.body.age,
        dni: req.body.dni,
        birthday: req.body.birthday,
        favouriteColour: req.body.favouriteColour,
        gender: req.body.gender,
    }};

    // Inserting a document
    db.get().db('apidb').collection('users').updateOne(filter, update,
    function (err, result) {
    // If there is an error, it will send the error to the next function
        if (err) {
            next ( new Error('Fallo en la conexión con la BD') );
            return;
        } else {
            // If everything is fine, it will return the result to the client
            res.send(result);
        }
    });
};

// Deleting users
module.exports.users_delete_one = function (req, res, next) {
    if (db.get() === null) {
        next(new Error('La conexión no está establecida'));
        return;
    }
    

    const filter = {_id: new mongodb.ObjectID(req.params.id)};
    
    // Deleting a document
    db.get().db('apidb').collection('users').deleteOne(filter, function
    (err, result) {
        // If there is an error, it will send the error to the next function
        if (err) {
            next ( new Error(`Fallo en la conexión con la BD: ${JSON.stringify(err)}`) );
            return;
        } else {
            // If everything is fine, it will return the result to the client
            res.status(200).json();
        }
    });
};


// Getting a single user
module.exports.users_get_one = function (req, res, next) {
    if (db.get() === null) {
        next(new Error('La conexión no está establecida'));
        return;
    }
    
    const filter = {_id: new mongodb.ObjectID(req.params.id)};

    db.get().db('apidb').collection('users').findOne(filter, function
    (err, result) {
        // If there is an error, it will send the error to the next function
        if (err) {
            next ( new Error(`Fallo en la conexión con la BD: ${JSON.stringify(err)}`) );
            return;
        } else if (!result) {
            return res.status(400).json({ errors: ['Usuario no encontrado']});
        } else {
            // If everything is fine, it will return the result to the client
            res.send(result);
        }
    });
};