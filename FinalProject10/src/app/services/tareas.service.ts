import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class TareasService {

  tarea: any;

  constructor(private http:HttpClient){
  }

    getTareasall() {
      return this.http.get("https://gorest.co.in/public/v1/todos");
    }

}
