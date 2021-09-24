import { Component } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Router } from '@angular/router'
import { TareasService } from 'src/app/services/tareas.service';

@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrls: ['./tarea.component.css']
})
export class TareaComponent {

  tarea:any = {};

  localTs: any;
  localerror: any;

  constructor( private fb:FormBuilder, public tareasService:TareasService, private router: Router ) { }

  ngOnInit(): void {}

  guardar(local: NgForm){

    if ( local.invalid ){

      Object.values( local.controls ).forEach( controls => {
        controls.markAsTouched();
      });
      local.reset();

      this.localerror = local.value

      this.localTs = local.value

    }
  }
}
