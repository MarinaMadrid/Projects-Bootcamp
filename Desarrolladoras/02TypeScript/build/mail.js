"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.defaultMail = exports.Mail = void 0;
var Mail = (function () {
    function Mail(_mailType, _mailAddress) {
        this._mailType = _mailType;
        this._mailAddress = _mailAddress;
    }
    Mail.prototype.toString = function () {
        return "{tipo: " + this._mailType + ", direcci\u00F3n: " + this._mailAddress + "}";
    };
    Object.defineProperty(Mail.prototype, "mailType", {
        get: function () {
            return this._mailType;
        },
        set: function (newMailType) {
            this._mailType = newMailType;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Mail.prototype, "mailAddress", {
        get: function () {
            return this._mailAddress;
        },
        set: function (newMailAddress) {
            this._mailAddress = newMailAddress;
        },
        enumerable: false,
        configurable: true
    });
    return Mail;
}());
exports.Mail = Mail;
exports.defaultMail = new Mail('type', 'mail@mail.com');
//# sourceMappingURL=mail.js.map