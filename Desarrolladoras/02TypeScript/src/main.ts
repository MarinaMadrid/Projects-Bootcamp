import {Person} from './person'
import {Address} from './address'
import {Mail} from './mail'
import {Phone} from './phone'


//Addresses
const addressPiruleta = new Address('piruleta', 24, 0, 'A', 29024, 'Malaga', 'Malaga')
const addressMagica = new Address('magica', 12, 3, 'B', 29130, 'Marbella', 'Málaga')
const addressGominola = new Address('gominola', 4, 6, 'C', 29010, 'Málaga', 'Málaga')
const addressFeliz = new Address('feliz', 32, 10, 'B', 29130, 'Torremolinos', 'Málaga')

//Mails
const mailMarina = new Mail('job', 'marina@mail.com')
const mailEsteban = new Mail('personal', 'esteban@mail.com')
const mailHomer = new Mail('personal', 'homer@mail.com')
const newMailEsteban = new Mail('job', 'esteban@mail.com')

//Phones
const phoneMarina = new Phone('job', 952111111)
const phoneEsteban = new Phone('personal', 658111111)
const phoneHomer = new Phone('job', 754123456)
const newPhoneEsteban = new Phone('job', 658111112)


//Agenda
let agenda = [
    new Person(
    '11111111M', 
    'Marina', 
    'Madrid', 
    27, 
    '10/10/69',
    'azul', 
    'F', 
    addressPiruleta, 
    mailMarina, 
    phoneMarina, 
    'Primera usuaria'),


    new Person(
        '33333333G',
        'Esteban',
        'Quito',
        24,
        '11/12/83',
        'verde',
        'M',
        addressMagica,
        mailEsteban,
        phoneEsteban,
        'Primer usuario'
    ),

    new Person(
        '44444444C',
        'Homer',
        'Simpson',
        45,
        '07/08/76',
        'morado',
        'F',
        addressGominola,
        mailHomer,
        phoneHomer,
        'Vicepresidente ejecutivo'
    ),
]


//Showing the users
console.log("Contactos \n")
for (let person of agenda){
    console.log(person.toString(),"\n")
}

//Changing an user
const targetNID = "33333333G";
for (let i in agenda){
    if (targetNID == agenda[i].NID){
        agenda[i].address = addressFeliz,
        agenda[i].mail = newMailEsteban,
        agenda[i].phone = newPhoneEsteban
    }
}

//Showing all users
console.log('Contactos con alguna modificación \n')
for (let person of agenda){
    console.log(person.toString(),"\n")
}