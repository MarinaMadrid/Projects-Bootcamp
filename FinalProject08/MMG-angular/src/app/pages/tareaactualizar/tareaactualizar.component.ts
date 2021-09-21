import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { TareasService } from '../../services/tareas.service';


@Component({
  selector: 'app-tareaactualizar',
  templateUrl: './tareaactualizar.component.html',
  styleUrls: ['./tareaactualizar.component.css']
})
export class TareaactualizarComponent implements OnInit {


  tarea:any = [{}];

  localTs: any;   
  localerror: any;

  constructor(private router: Router, private activatedRouter: ActivatedRoute, private servitareas: TareasService) {

    this.activatedRouter.params.subscribe( params => {
      this.tarea = this.servitareas.getTarea(params['id']-1);

    })

   }

  ngOnInit(): void {
  }


  actualizar(local: NgForm){  


    if ( local.invalid ){  
      
      Object.values( local.controls ).forEach( controls => {  
        
        controls.markAsTouched();  
      });
      local.reset();  

    this.localerror = local.value

    // console.log(this.localerror);
    
    const nombre_promesa = new Promise (( resolve, reject ) => {

      setTimeout(() => {
          resolve ('');   
      }, 2000);
  
    });
    
    nombre_promesa.then ( () => 
      
      this.router.navigate(['/tareas'])
    .then(() => {
      window.location.reload();
    })
    )
    .catch ( err => console.log( err ));
  
    return;
  }
  


  const nombre_promesa = new Promise (( resolve, reject ) => {

    setTimeout(() => {
        resolve ('');   
    }, 2000);

  });
  
  nombre_promesa.then ( () => 

  this.router.navigate(['/tareas'])
)
.catch ( err => console.log( err ));

    // console.log(local.value);

    this.localTs = local.value

  }



}
