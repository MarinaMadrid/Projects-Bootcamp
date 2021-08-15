"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.defaultAddress = exports.Address = void 0;
var Address = (function () {
    function Address(_street, _streetNumber, _floor, _letter, _postcode, _town, _province) {
        this._street = _street;
        this._streetNumber = _streetNumber;
        this._floor = _floor;
        this._letter = _letter;
        this._postcode = _postcode;
        this._town = _town;
        this._province = _province;
    }
    Address.prototype.toString = function () {
        return "{calle: " + this._street + ", n\u00FAmero: " + this._streetNumber + ", piso: " + this._floor + ", letra: " + this._letter + ", c\u00F3digo postal: " + this._postcode + ", poblaci\u00F3n: " + this._town + ", provincia: " + this._province + "}";
    };
    Object.defineProperty(Address.prototype, "street", {
        get: function () {
            return this._street;
        },
        set: function (newStreet) {
            this._street = newStreet;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "streetNumber", {
        get: function () {
            return this._streetNumber;
        },
        set: function (newStreetNumber) {
            this._streetNumber = newStreetNumber;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "floor", {
        get: function () {
            return this._floor;
        },
        set: function (newFloor) {
            this._floor = newFloor;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "letter", {
        get: function () {
            return this._letter;
        },
        set: function (newLetter) {
            this._letter = newLetter;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "postcode", {
        get: function () {
            return this._postcode;
        },
        set: function (newPostCode) {
            this._postcode = newPostCode;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "town", {
        get: function () {
            return this._town;
        },
        set: function (newTown) {
            this._town = newTown;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "province", {
        get: function () {
            return this._province;
        },
        set: function (newProvince) {
            this._province = newProvince;
        },
        enumerable: false,
        configurable: true
    });
    return Address;
}());
exports.Address = Address;
exports.defaultAddress = new Address('street', 24, 1, 'A', 29024, 'city', 'province');
//# sourceMappingURL=address.js.map