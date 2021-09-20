import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactosService } from 'src/app/services/contactos.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  users: string = '';

  constructor(public contactosService: ContactosService, public router: Router) {
  }

  login() {
    const user = { email: this.email, password: this.password };
    this.contactosService.login(user).subscribe(data => {
      //this.contactosService.setToken(data.token);
      this.users = user.email;
      this.contactosService.guardartoken(data.token);
      this.router.navigateByUrl('/home').then(() => { //actualiza el navbar para que aparezca el nombre del usuario conectado, sin actualizar manualmente
        window.location.reload();
      });
      console.log(data);
    },
    error => {
      console.log(error);
    });
  }
}
