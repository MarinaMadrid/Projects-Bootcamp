import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactosService } from 'src/app/services/contactos.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  conectados: string = '';
  loggedUser: any[] = []; //contacto que ha iniciado sesión (conectado)

  // LOCALSTORAGE
  usartoken: any;
  id_usuario_token: any;

  constructor(private _contactosService: ContactosService, private router: Router) { }

  ngOnInit(): void {
    this.conectado();
  }

  conectado() {
    let Data2: any;


    //Coge el id del localstorage
    // console.log(localStorage.getItem('token'));
    if (localStorage.getItem('token')) {
      this.usartoken = localStorage.getItem('token');
      this.id_usuario_token = this.usartoken.charAt(this.usartoken.length - 2);
      // console.log("Home ", this.id_usuario_token);


      for (let i = 1; i <= 5; i++) {
        this._contactosService.getUser(i).subscribe((user2: any) => {

          Data2 = {
            email2: user2.data[i].email,
            id2: user2.data[i].id,
            nombre2: user2.data[i].first_name,
            apellido2: user2.data[i].last_name,  //apellido u otro nombre
            avatar2: user2.data[i].avatar
          };

          this.loggedUser.push(Data2);

          if (user2.data[i].id == this.id_usuario_token) {
            // console.log(Data2.nombre);
            this.conectados = Data2.nombre2;

          }
        });
      }
    }
    //fin del LOCALSTORAGE
  }

  //LOGOUT
  salir() {
    this._contactosService.logout();
    this.router.navigate(['/login'])
      .then(() => {
        window.location.reload();
      });
  }
}
