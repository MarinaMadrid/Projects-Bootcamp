import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlumnosServicio } from '../../servicio/alumnosservicio.service';
import { FormGroup } from '@angular/forms';
import { AlumnosModel } from '../../models/alumnos.model';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-Alumno',
  templateUrl: './Alumno.component.html',
  styleUrls: ['./Alumno.component.css']
})
export class AlumnoComponent implements OnInit {

  FormGroup: FormGroup;

  AlumnosModel = new AlumnosModel();
  
  alumno: any = '';   

  constructor(private servicefire: AlumnosServicio,
    private router: Router,
    private Route: ActivatedRoute) { 
      
    }

    ngOnInit() {
      const id = this.Route.snapshot.paramMap.get('id');          
      console.log(id);
  
        if ( id !== 'nuevo' ){                                        
            this.servicefire.getUnElemento(id).subscribe( (resp: AlumnosModel) => {     
            console.log(resp);
        
            this.AlumnosModel = resp;                                   
            this.AlumnosModel.id = id;                                       
            });
          }
    }

    guardar( cogerDatos: NgForm ){         

      if ( cogerDatos.invalid ){       
         console.log('Formulario no válido');
          return;
      }

      Swal.fire({                                                                                    
        title: 'Espere',                                                                                
        text: 'Guardando información',                                                                   
         icon: 'info',    
        allowOutsideClick: false                                                                         
        });
        Swal.showLoading();                                                                                 
    

        let peticion: Observable<any>; 

      if (this.AlumnosModel.id){                                                                                
        peticion = this.servicefire.actualizaralumnos(this.AlumnosModel);                           
        peticion.subscribe( resp => {
          Swal.fire({                                                                                  
          title: this.AlumnosModel.nombre,                                                                     
          text: 'Se actualizó correctamente',                                                              
           icon: 'success'
          });
        });
    }else{
      peticion = this.servicefire.crearalumnos(this.AlumnosModel);                                
      peticion.subscribe( resp => {                                               
          Swal.fire({
          title: this.AlumnosModel.nombre,
          text: 'Se guardó correctamente',
          icon: 'success'
          });
      });
    }

  }
  
      salir(){                             
      // this.servicefire.logout();               
      this.router.navigateByUrl('/home');     
    }
  
  

}
