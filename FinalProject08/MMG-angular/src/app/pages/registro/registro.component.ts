import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactosService } from 'src/app/services/contactos.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent {
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  passwordError: boolean = false;

  contrasena: any;
  correcto: string = '';

  constructor(public contactosService: ContactosService, public router: Router) { }

  register() {
    const user = { email: this.email, password: this.password, confirmPassword: this.confirmPassword };
    this.contactosService.register(user).subscribe(data => {
      //this.contactosService.setToken(data.token);
      if (this.password == this.confirmPassword) {
        this.contrasena = this.password;
        this.correcto = "La contraseña ha sido creada correctamente";
        console.log(this.contrasena);
      } else {
        this.correcto = "Las contraseñas no coinciden";
        console.log(this.contrasena);
      }
    },
    error => {
      console.log(error);
    });
  }
}
