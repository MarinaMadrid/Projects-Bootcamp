import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Tarea } from 'src/app/models/tarea.model';
import { TareasService } from 'src/app/services/tareas.service';

@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrls: ['./tarea.component.css']
})
export class TareaComponent {

  tarea:any = {};

  constructor( private activatedRoute:ActivatedRoute, private _tareasService:TareasService ) {
    this.activatedRoute.params.subscribe( params => {
      this.tarea = this._tareasService.getTarea(params['id']);
    })
  }

}
