import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Person } from './../interface/person';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  do: String = "insert"
  position: any = 0

  contacts: Array<Person> = []

  contact: Person = {
        name: "",
        surnames: "",
        age: "",
        dni: "",
        birthday: "",
        favouriteColour: "",
        gender: "",
  }

  genders = [
    { id: 1, value: 'Hombre' },
    { id: 2, value: 'Mujer' },
    { id: 3, value: 'Otro'},
    { id: 4, value: 'No especificado'},
  ];

  favouriteColours = [
    { id: 0, value: 'Blanco' },
    { id: 1, value: 'Rojo' },
    { id: 2, value: 'Azul' },
    { id: 3, value: 'Amarillo' },
    { id: 4, value: 'Verde' },
    { id: 5, value: 'Rosa' },
    { id: 6, value: 'Morado' },
    { id: 7, value: 'Marrón' },
    { id: 8, value: 'Naranja' },
    { id: 9, value: 'Negro' },
  ];



  constructor() { }

  ngOnInit(): void {
  }
  add( form : NgForm ){
    if( this.do === 'insert' ){

      let birthDate  = new Date(this.contact.birthday);
      let day = birthDate.getDay();
      let month = birthDate.getMonth();
      let year = birthDate.getFullYear();
      let ageNum = parseInt(this.contact.age)

      this.contact.birthday = `${day}/${month}/${year}`
      if(ageNum > 0 && ageNum <= 125){
      this.contacts.push( this.contact )
      }
      this.contact = {
        name: "",
        surnames: "",
        age: "",
        dni: "",
        birthday: new Date(),
        favouriteColour: "",
        gender: "",
      }

    }else{
      this.contacts[ this.position ] = this.contact
      this.do = 'insert'
    }
    form.resetForm()
  }

  delete( delPosition : number )    : void {
    this.contacts.splice( delPosition , 1 )
  }
  update( upPosition : number ) : void {
    this.contact  = this.contacts[ upPosition ];
    this.do   = 'update'
    this.position = upPosition
  }

}
