import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from "@angular/forms";

//Servicios
import { ContactosService } from './services/contactos.service';
import { TareasService } from './services/tareas.service';
//import { CookieService } from 'ngx-cookie-service';

//Rutas
import { APP_ROUTING } from './routes/app.routes';

//Componentes
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { ListaTareasComponent } from './views/lista-tareas/lista-tareas.component';
import { ListaContactosComponent } from './views/lista-contactos/lista-contactos.component';
import { ContactoComponent } from './components/contacto/contacto.component';
import { TareaComponent } from './components/tarea/tarea.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistroComponent } from './pages/registro/registro.component';
import { FooterComponent } from './components/shared/footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    ListaTareasComponent,
    ListaContactosComponent,
    ContactoComponent,
    TareaComponent,
    LoginComponent,
    RegistroComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    APP_ROUTING,
    ReactiveFormsModule
  ],
  providers: [
    ContactosService,
    TareasService,
    //CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
