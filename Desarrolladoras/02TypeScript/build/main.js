"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var person_1 = require("./person");
var address_1 = require("./address");
var mail_1 = require("./mail");
var phone_1 = require("./phone");
var addressPiruleta = new address_1.Address('piruleta', 24, 0, 'A', 29024, 'Malaga', 'Malaga');
var addressMagica = new address_1.Address('magica', 12, 3, 'B', 29130, 'Marbella', 'Málaga');
var addressGominola = new address_1.Address('gominola', 4, 6, 'C', 29010, 'Málaga', 'Málaga');
var addressFeliz = new address_1.Address('feliz', 32, 10, 'B', 29130, 'Torremolinos', 'Málaga');
var mailMarina = new mail_1.Mail('job', 'marina@mail.com');
var mailEsteban = new mail_1.Mail('personal', 'esteban@mail.com');
var mailHomer = new mail_1.Mail('personal', 'homer@mail.com');
var newMailEsteban = new mail_1.Mail('job', 'esteban@mail.com');
var phoneMarina = new phone_1.Phone('job', 952111111);
var phoneEsteban = new phone_1.Phone('personal', 658111111);
var phoneHomer = new phone_1.Phone('job', 754123456);
var newPhoneEsteban = new phone_1.Phone('job', 658111112);
var agenda = [
    new person_1.Person('11111111M', 'Marina', 'Madrid', 27, '10/10/69', 'azul', 'F', addressPiruleta, mailMarina, phoneMarina, 'Primera usuaria'),
    new person_1.Person('33333333G', 'Esteban', 'Quito', 24, '11/12/83', 'verde', 'M', addressMagica, mailEsteban, phoneEsteban, 'Primer usuario'),
    new person_1.Person('44444444C', 'Homer', 'Simpson', 45, '07/08/76', 'morado', 'F', addressGominola, mailHomer, phoneHomer, 'Vicepresidente ejecutivo'),
];
console.log("Contactos \n");
for (var _i = 0, agenda_1 = agenda; _i < agenda_1.length; _i++) {
    var person = agenda_1[_i];
    console.log(person.toString(), "\n");
}
var targetNID = "33333333G";
for (var i in agenda) {
    if (targetNID == agenda[i].NID) {
        agenda[i].address = addressFeliz,
            agenda[i].mail = newMailEsteban,
            agenda[i].phone = newPhoneEsteban;
    }
}
console.log('Contactos con alguna modificación \n');
for (var _a = 0, agenda_2 = agenda; _a < agenda_2.length; _a++) {
    var person = agenda_2[_a];
    console.log(person.toString(), "\n");
}
//# sourceMappingURL=main.js.map