// Importing dependencies
//var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var usersRouter = require('./routes/users');

// Creating the app
var app = express();

// The module is configured to generate a log of the requests received by the server and view them through the console
app.use(logger('dev'));

// A middleware is configured to translate all JSON type requests to facilitate their treatment
app.use(express.json());

// Middlware to decode the content of the parameters that are encoded in the requests
app.use(express.urlencoded({ extended: false }));

// Module to facilitate the treatment of cookies
app.use(cookieParser());

// Module to facilitate the treatment of static resources
app.use(express.static(path.join(__dirname, 'public')));

// The application routes are defined
var usersRouter = require('./routes/users');
app.use('/users', usersRouter);

// The application is exported so that it can be used from other files that include app.js
module.exports = app;