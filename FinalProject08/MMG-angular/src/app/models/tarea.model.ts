export class Tarea {
    id: any;
    titulo: string;
    descripcion: string;
    urgencia: any; //del 1 al 5 siendo 1 la más urgente
    responsable: string; 
    fechaInicio: string;
    fechaFin: string;

    constructor(id: any, titulo: string, descripcion: string, urgencia: any, responsable: string, fechaInicio: string, fechaFin: string){

    this.id = id;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.urgencia = urgencia;
    this.responsable = responsable;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
  }
}