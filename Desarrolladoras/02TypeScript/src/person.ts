import {Address, defaultAddress} from './address'
import {Mail, defaultMail} from './mail'
import {Phone, defaultPhone} from './phone'

export class Person {
  
    constructor(private _NID:string = 'nid', 
        private _name:string = 'name',
        private _surname:string = 'surname',
        private _age:number = 26,
        private _birthday:string = '27/09/15',
        private _favouriteColour:string = 'colour',
        private _gender:string = 'gender',
        private _address:Address = defaultAddress,
        private _mail:Mail = defaultMail,
        private _phone:Phone = defaultPhone,
        private _notes:string = 'notes',
    ) {}

    toString(){
        return `Contacto: {DNI: ${this.NID}, nombre: ${this.name}, apellidos: ${this.surname}, edad: ${this.age}, cumpleaños:  ${this.birthday}, color favorito: ${this.favouriteColour}, sexo: ${this.gender}, dirección: ${this._address.toString()}, correo electrónico: ${this._mail.toString()}, teléfono: ${this._phone.toString()}, notas: ${this._notes}}`
    }

    get NID():string{
        return this._NID;
    }

    set NID(newNID:string){
        this._NID = newNID;
    }

    get name():string{
        return this._name;
    }

    set name(newName:string){
        this._name = newName;
    }

    get surname():string{
        return this._surname;
    }

    set surname(newSurname:string){
        this._surname = newSurname;
    }

    get age():number{
        return this._age;
    }

    set age(newAge:number){
        this._age = newAge;
    }

    get birthday():string{
        return this._birthday;
    }

    set birthday(newBirthday:string){
        this._birthday = newBirthday;
    }

    get favouriteColour():string{
        return this._favouriteColour;
    }

    set favouriteColour(newFavouriteColour:string){
        this._favouriteColour = newFavouriteColour;
    }

    get gender():string{
        return this._gender;
    }

    set gender(newGender:string){
        this._gender = newGender;
    }

    get address():Address{
        return this._address;
    }

    set address(newAddress:Address){
        this._address = newAddress;
    }

    get mail():Mail{
        return this._mail;
    }

    set mail(newMail:Mail){
        this._mail = newMail;
    }

    get phone():Phone{
        return this._phone;
    }

    set phone(newPhone:Phone){
        this._phone = newPhone;
    }

    get notes():string{
        return this._notes;
    }

    set notes(newNotes:string){
        this._notes = newNotes;
    }

}

