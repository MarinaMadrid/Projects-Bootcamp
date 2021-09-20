import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router  } from '@angular/router';
import { Observable } from 'rxjs';
import { AlumnosServicio } from '../../../servicio/alumnosservicio.service';

@Injectable({
  providedIn: 'root'
})
export class LoginguardGuard implements CanActivate {

  constructor( private alumnosService: AlumnosServicio,  //Manejo del servicio
    private router: Router){ }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      if(this.alumnosService.guardEstaAutentificado()){                             
        return true;                                                                    
        }else{
        this.router.navigateByUrl('/login');                                               
      }
      
  }
  
}
