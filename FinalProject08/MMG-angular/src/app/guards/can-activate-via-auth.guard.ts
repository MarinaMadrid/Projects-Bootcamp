import { state } from '@angular/animations';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { CanActivate } from '@angular/router';
import { Observable } from 'rxjs';
import { ContactosService } from '../services/contactos.service';

@Injectable({
  providedIn: 'root'
})


export class CanActivateViaAuthGuard implements CanActivate {

  constructor(private auth: ContactosService,  //Manejo del servicio
  private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    if (this.auth.isLoggedIn()) {   //Si isLoggedIn (si coge token)
      return true;
    } else {
      window.alert("Inicie sesión para poder entrar");
      return false;
    }
  }
}