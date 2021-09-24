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

  constructor( public tareasService:TareasService, private router:Router) { }

  ngOnInit(): void {

    this.getall();
  }

  getall(){
    this.tareasService.getTareasall().subscribe( (resp:any) =>{

      if(resp?.data?.length){
        console.log(resp);

        const { data } = resp;
        this.tareas = [...this.tareas, ...data ];
      }

      else{
        this.tareas = [];
      }

    })
  }

  eliminarTarea(idx:number){
    this.tareas.splice( idx , 1 )
  }


}
