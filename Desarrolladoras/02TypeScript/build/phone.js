"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.defaultPhone = exports.Phone = void 0;
var Phone = (function () {
    function Phone(_phoneType, _phoneNumber) {
        this._phoneType = _phoneType;
        this._phoneNumber = _phoneNumber;
    }
    Phone.prototype.toString = function () {
        return "{tipo: " + this._phoneType + ", n\u00FAmero: " + this._phoneNumber + "}";
    };
    Object.defineProperty(Phone.prototype, "phoneType", {
        get: function () {
            return this._phoneType;
        },
        set: function (newPhoneType) {
            this._phoneType = newPhoneType;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Phone.prototype, "phoneNumber", {
        get: function () {
            return this._phoneNumber;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Phone.prototype, "number", {
        set: function (newPhoneNumber) {
            this._phoneNumber = newPhoneNumber;
        },
        enumerable: false,
        configurable: true
    });
    return Phone;
}());
exports.Phone = Phone;
exports.defaultPhone = new Phone('type', 952111111);
//# sourceMappingURL=phone.js.map