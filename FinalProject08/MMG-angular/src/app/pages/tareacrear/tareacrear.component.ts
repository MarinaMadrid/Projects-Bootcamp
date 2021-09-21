import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { TareasService } from '../../services/tareas.service';

@Component({
  selector: 'app-tareacrear',
  templateUrl: './tareacrear.component.html',
  styleUrls: ['./tareacrear.component.css']
})
export class TareacrearComponent implements OnInit {

  tarea:any = {};

  localTs: any;   
  localerror: any;

  constructor(private router: Router) {}

  ngOnInit(): void {
  }


  guardar(local: NgForm){  

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
      }, 1000);
  
    });
    
    nombre_promesa.then ( () => 
      
      this.router.navigate(['/tareacrear/nuevo'])
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
