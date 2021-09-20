import { RouterModule, Routes } from '@angular/router';
import { CanActivateViaAuthGuard } from '../guards/can-activate-via-auth.guard';

//Componentes
import { ContactoComponent } from '../components/contacto/contacto.component';
import { HomeComponent } from '../pages/home/home.component';
import { LoginComponent } from '../pages/login/login.component';
import { RegistroComponent } from '../pages/registro/registro.component';
import { ListaContactosComponent } from '../views/lista-contactos/lista-contactos.component';
import { ListaTareasComponent } from '../views/lista-tareas/lista-tareas.component';
import { TareaComponent } from '../components/tarea/tarea.component';


const APP_ROUTES: Routes = [
  { path: "home", component: HomeComponent, canActivate: [ CanActivateViaAuthGuard ] },
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'contactos', component: ListaContactosComponent, canActivate: [ CanActivateViaAuthGuard ] },
  { path: 'tareas', component: ListaTareasComponent, canActivate: [ CanActivateViaAuthGuard ] },
  { path: 'contacto/:id', component: ContactoComponent, canActivate: [ CanActivateViaAuthGuard ] },
  { path: 'tarea/:id', component: TareaComponent, canActivate: [ CanActivateViaAuthGuard ] },
  { path: '**', pathMatch: 'full', redirectTo: 'login'}
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
