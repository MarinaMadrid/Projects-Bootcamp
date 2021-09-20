import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AlumnosModel } from '../../models/alumnos.model';
import { AlumnosServicio } from '../../servicio/alumnosservicio.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router'; 

//redux
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';

//redux
interface AppState{õ
  mesagge: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario: AlumnosModel = new AlumnosModel ();
  botonRecordar = false;

    //redux
    mesagge$: Observable<string>

  constructor( private servicefire: AlumnosServicio,
               private router: Router,
               //redux
                private store: Store<AppState> ) { 
                  this.mesagge$ = this.store.select('mesagge')
                }

  ngOnInit() {
    if( localStorage.getItem('id') ){                    
      this.usuario.id = localStorage.getItem('id');     
      this.botonRecordar = true;                              
      }
  }

  login (form:NgForm){                                          
    if(form.invalid){                                               
    return;
    }

    Swal.fire({              
      allowOutsideClick: false,                                       
      icon: 'info',                                                   
      text: 'Espere por favor'
    });
      
      Swal.showLoading();

    // console.log(this.usuario);                                          
    // console.log('Imprimir si el formulario es válido');


    this.servicefire.login( this.usuario ).subscribe( resp => {   
      // console.log (resp);    

      Swal.close();  

      if( this.botonRecordar ){                        
        localStorage.setItem('email', this.usuario.id);   
        }

      this.router.navigateByUrl('/home');

      }, (err) => {                                                 
      
          console.log (err);
          console.log (err.error.error.message);
      
          Swal.fire({                                              
            icon: 'error',                                            
            title: 'Error al autenticar',                               
            text: err.error.error.message
          });

        });

  }


    //redux
    spanishmesagge(){
      this.store.dispatch({type: 'Spanish'})
    }
  
    englishmesagge(){
      this.store.dispatch({type: 'English'})
    }
}
