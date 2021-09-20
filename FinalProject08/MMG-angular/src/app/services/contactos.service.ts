import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
//import { CookieService } from "ngx-cookie-service";


@Injectable({
  providedIn: 'root'
})

export class ContactosService {

  usartoken: any;
  id_usuario_token: any;

  constructor(private http: HttpClient,
    //private cookies: CookieService
  ) {
    //console.log("Servicio listo para usar!!!")
  }

   //COOKIES
  /*
  setToken(token: String) {
    this.cookies.set("token", token as 'json');//
  }
  getToken() {
    return this.cookies.get("token");
  }
  */

  //LOCALSTORAGE
  login(user: any): Observable<any> {
    return this.http.post("https://reqres.in/api/login", user).pipe(map((resp: any) => {
      // console.log ('Entro en el mapa del RXJS');                                                                       
      this.guardartoken(resp.toString['idToken']);
      return resp;
    })
    );
  }

  register(user: any): Observable<any> {
    return this.http.post("https://reqres.in/api/register", user);
  }

  logout() {
    localStorage.removeItem('token');
    //return this.cookies.delete("token"); //eliminar cookies
  }

  //Usuarios
  getUser(user: any) {
    return this.http.get("https://reqres.in/api/users/", user);
  }

  //LOGIN
  guardartoken(idToken: string) {
    this.usartoken = idToken;
    localStorage.setItem('token', JSON.stringify(idToken)); 

    let hoy = new Date();
    hoy.setSeconds(3600);
    localStorage.setItem('variableExpira', hoy.getTime().toString());
  }

  leertoken() {
    if (localStorage.getItem('token')) {
      this.usartoken = localStorage.getItem('token');
    } else {
      this.usartoken = '';
    }

    this.id_usuario_token = this.usartoken.charAt(this.usartoken.length - 2);

    //console.log("id del usuario: ",this.id_usuario_token);  //vemos en consola el token, sacamos la id, ya que he visto que del "QpwL5tke4Pnpja7X4" que se guarda el último corresponde al id del usuario

    return this.usartoken;
  }

  guardEstaAutentificado(): boolean {
    if (this.usartoken.length < 2) {
      return false;
    }

    const variableExpira = Number(localStorage.getItem('variableExpira'));
    const variableExpira2 = new Date();
    variableExpira2.setTime(variableExpira);

    if (variableExpira2 > new Date()) {
      return true;
    } else {
      return false;
    }
  }

  isLoggedIn(): boolean {
    if(localStorage.getItem('token')){
      return true;
    } else {
      return false;
    }
  }

  //REGISTRO
  guardartoken2(idToken: string) {
    this.usartoken = idToken;
    localStorage.setItem('token2', (idToken));

    let hoy = new Date();
    hoy.setSeconds(3600);
    localStorage.setItem('variableExpira2', hoy.getTime().toString());
  }

}
