import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContactosService } from 'src/app/services/contactos.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})

export class ContactoComponent {
  contacto: any = '';
  id = '';
  email = '';
  nombre = '';
  apellido = '';
  avatar = '';  
  errorN: string = '';

  contactoService:any = {};    

  constructor( activatedRoute: ActivatedRoute, private _contactosService: ContactosService) { 
    activatedRoute.params.subscribe ( params => {
      console.log( params['id'] );
      this.getContacto(params['id']);
    });
  }
  
  getContacto(id:any){  
    this._contactosService.getUser(id).subscribe(   
    res => {  
      //console.log(res);
      this.contacto = res;    
      this.id = this.contacto.data[id-1].id;  
      //console.log(this.id-1);
      this.email = this.contacto.data[id-1].email;  
      this.nombre = this.contacto.data[id-1].first_name;  
      this.apellido = this.contacto.data[id-1].last_name;  
      this.avatar = this.contacto.data[id-1].avatar;   

    },
    err => {   
      console.log(err);
      this.errorN = err.error  
    });
  }


}

