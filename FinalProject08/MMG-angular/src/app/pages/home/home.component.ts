import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactosService } from 'src/app/services/contactos.service';
import { TareasService } from 'src/app/services/tareas.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  
  constructor(private _contactosService:ContactosService, private _tareasService:TareasService, private router:Router) { }

  ngOnInit(): void {
  }

  verContactos(){
    this.router.navigate(['/contactos']);
  }

  verTareas(){
    this.router.navigate(['/tareas']);
  }
}
