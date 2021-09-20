import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2'
import { AlumnosServicio } from '../../servicio/alumnosservicio.service';
import { AlumnosModel } from '../../models/alumnos.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  alumnos: AlumnosModel[] = [];

  usuario: AlumnosModel = new AlumnosModel ();




  constructor(  private servicefire: AlumnosServicio,
    private router: Router ) { 
      
    }

  ngOnInit() {
    this.servicefire.getTodosElementos().subscribe( respuesta => {     
      console.log(respuesta);
      this.alumnos = respuesta;                                                 
    });

    if( localStorage.getItem('id') ){                    
      this.usuario.id = localStorage.getItem('id');                              
      }
  }

  borrarUnElemento(  borrar: AlumnosModel, i: number ){                       

    Swal.fire({
      title: '¿Estás seguro?',
      text: `Está seguro que desea borrar a ${ borrar.nombre }`,     
      icon: 'question',
      showConfirmButton: true,                                                  
      showCancelButton: true,
    }).then(variableContestacion => {                                       
      if (variableContestacion.value){                                      
          
          this.alumnos.splice(i, 1);                                                  
  
          this.servicefire.borrarElemento( borrar.id ).subscribe();         
      }
    });         
}


  salir(){                             
    this.servicefire.logout();               
    this.router.navigateByUrl('/login').then(() => { 
      window.location.reload();
    });   
  }





}
