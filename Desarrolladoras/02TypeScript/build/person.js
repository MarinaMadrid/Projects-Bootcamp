"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Person = void 0;
var address_1 = require("./address");
var mail_1 = require("./mail");
var phone_1 = require("./phone");
var Person = (function () {
    function Person(_NID, _name, _surname, _age, _birthday, _favouriteColour, _gender, _address, _mail, _phone, _notes) {
        if (_NID === void 0) { _NID = 'nid'; }
        if (_name === void 0) { _name = 'name'; }
        if (_surname === void 0) { _surname = 'surname'; }
        if (_age === void 0) { _age = 27; }
        if (_birthday === void 0) { _birthday = '27/09/15'; }
        if (_favouriteColour === void 0) { _favouriteColour = 'colour'; }
        if (_gender === void 0) { _gender = 'gender'; }
        if (_address === void 0) { _address = address_1.defaultAddress; }
        if (_mail === void 0) { _mail = mail_1.defaultMail; }
        if (_phone === void 0) { _phone = phone_1.defaultPhone; }
        if (_notes === void 0) { _notes = 'notes'; }
        this._NID = _NID;
        this._name = _name;
        this._surname = _surname;
        this._age = _age;
        this._birthday = _birthday;
        this._favouriteColour = _favouriteColour;
        this._gender = _gender;
        this._address = _address;
        this._mail = _mail;
        this._phone = _phone;
        this._notes = _notes;
    }
    Person.prototype.toString = function () {
        return "Contacto: {DNI: " + this.NID + ", nombre: " + this.name + ", apellidos: " + this.surname + ", edad: " + this.age + ", cumplea\u00F1os:  " + this.birthday + ", color favorito: " + this.favouriteColour + ", sexo: " + this.gender + ", direcci\u00F3n: " + this._address.toString() + ", correo electr\u00F3nico: " + this._mail.toString() + ", tel\u00E9fono: " + this._phone.toString() + ", notas: " + this._notes + "}";
    };
    Object.defineProperty(Person.prototype, "NID", {
        get: function () {
            return this._NID;
        },
        set: function (newNID) {
            this._NID = newNID;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (newName) {
            this._name = newName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "surname", {
        get: function () {
            return this._surname;
        },
        set: function (newSurname) {
            this._surname = newSurname;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "age", {
        get: function () {
            return this._age;
        },
        set: function (newAge) {
            this._age = newAge;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "birthday", {
        get: function () {
            return this._birthday;
        },
        set: function (newBirthday) {
            this._birthday = newBirthday;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "favouriteColour", {
        get: function () {
            return this._favouriteColour;
        },
        set: function (newFavouriteColour) {
            this._favouriteColour = newFavouriteColour;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "gender", {
        get: function () {
            return this._gender;
        },
        set: function (newGender) {
            this._gender = newGender;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "address", {
        get: function () {
            return this._address;
        },
        set: function (newAddress) {
            this._address = newAddress;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "mail", {
        get: function () {
            return this._mail;
        },
        set: function (newMail) {
            this._mail = newMail;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "phone", {
        get: function () {
            return this._phone;
        },
        set: function (newPhone) {
            this._phone = newPhone;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "notes", {
        get: function () {
            return this._notes;
        },
        set: function (newNotes) {
            this._notes = newNotes;
        },
        enumerable: false,
        configurable: true
    });
    return Person;
}());
exports.Person = Person;
//# sourceMappingURL=person.js.map