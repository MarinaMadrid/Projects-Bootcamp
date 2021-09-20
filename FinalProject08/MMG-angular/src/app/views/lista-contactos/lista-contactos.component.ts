import { Component, OnInit } from '@angular/core';
import { Contacto } from 'src/app/models/contacto.model';
import { ContactosService } from 'src/app/services/contactos.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-contactos',
  templateUrl: './lista-contactos.component.html',
  styleUrls: ['./lista-contactos.component.css']
})
export class ListaContactosComponent implements OnInit {
  users: Contacto[] = []; //todos los contactos

  constructor(private _contactosService: ContactosService, private router: Router) { }

  ngOnInit(): void {
    //this.contactos = this._contactosService.getContactos();
    //console.log(this.contactos);
    this.getUsersLogged();
    this._contactosService.leertoken();
  }

  getUsersLogged() {

    let Data: Contacto;

    for (let i = 0; i <= 5; i++) {
      this._contactosService.getUser(i).subscribe((user: any) => {
        Data = {
          id: user.data[i].id,
          email: user.data[i].email,
          nombre: user.data[i].first_name,
          apellido: user.data[i].last_name,  //apellido u otro nombre
          avatar: user.data[i].avatar
        };
        this.users.push(Data);
        //console.log(Data);
      });
    }
  }
}
