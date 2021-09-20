import { Component, OnInit } from '@angular/core';
import { Tarea } from 'src/app/models/tarea.model';
import { TareasService } from 'src/app/services/tareas.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-tareas',
  templateUrl: './lista-tareas.component.html',
  styleUrls: ['./lista-tareas.component.css']
})
export class ListaTareasComponent implements OnInit {

  tareas:Tarea[] = [];

  constructor( private _tareasService:TareasService, private router:Router) { }

  ngOnInit(): void {
    this.tareas = this._tareasService.getTareas();

    console.log(this.tareas);
  }

  verTarea(idx:number){
    this.router.navigate(['/tarea', idx]);
  }

  eliminarTarea(idx:number){
    this.tareas.splice( idx , 1 )
  }
}
