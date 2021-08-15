import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Person } from '../interface/person';
import { ContactService } from '../services/contact.service'

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  do: String = "insert"
  position: any = 0

  contacts: Array<Person> = []

  contact: Person = new Person();

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



  constructor(private service: ContactService ) {

  }

  ngOnInit(): void {
    this.updateList();
  }

  add( form : NgForm ){
    if( this.do === 'insert' ){


      let birthDate  = new Date(this.contact.birthday);
      let dayNum = birthDate.getDay();
      let day = dayNum < 10 ? `0${dayNum}` : `${dayNum}`;
      let monthNum = birthDate.getMonth() + 1;
      let month = monthNum < 10 ? `0${monthNum}` : `${monthNum}`;
      let year = birthDate.getFullYear();
      let ageNum = parseInt(this.contact.age)

      this.contact.birthday = `${year}-${month}-${day}`
      if(ageNum > 0 && ageNum <= 125){
        this.service.postContact(this.contact).subscribe(
          _ => this.updateList(),
          err => alert(`Comprueba los errores: ${JSON.stringify(err.error.errors)}`)
          )
      }
      this.contact = new Person();
      this.contact.birthday = new Date();

    }else{
      this.service.putContact(this.contact).subscribe(_ =>{
        this.updateList();
        this.do = 'insert';
      });
    }
    form.resetForm()
  }

  deleteContact( id : string )    : void {
    this.service.deleteContact(id).subscribe(_ => this.updateList());
  }

  updateList(){
    this.service.getContacts().subscribe(res => this.contacts = res as Person[])
  }

  update( id : string ) : void {
    this.service.getContact(id).subscribe(res => {
      this.contact = res as Person;
      this.do = 'update';
    });
  }

}
