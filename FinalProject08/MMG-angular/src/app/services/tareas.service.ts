import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tarea } from '../models/tarea.model';

@Injectable()
export class TareasService {

  private tareas:Tarea[] = [
    {
      id: 1,
      titulo: "Base de datos",
      descripcion: "Hacer base de datos",
      urgencia: 3,
      responsable: "Eve",
      fechaInicio: "10/09/20",
      fechaFin: "17/09/20"
    },
    {
      id: 2,
      titulo: "Testing",
      descripcion: "Hacer tests unitarios",
      urgencia: 1,
      responsable: "George",
      fechaInicio: "10/09/20",
      fechaFin: "17/09/20"
    },
    {
      id: 3,
      titulo: "Maquetación",
      descripcion: "Hacer maquetación web",
      urgencia: 2,
      responsable: "Janet",
      fechaInicio: "10/09/20",
      fechaFin: "17/09/20"
    },
  ];

  constructor(private http:HttpClient){
    //console.log("Servicio listo para usar!!!")
  }

  getTareas():Tarea[]{
    return this.tareas;
  }

  getTarea(idx:number){
    return this.tareas[idx];
  }

}
