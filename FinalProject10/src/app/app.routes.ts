import { RouterModule, Routes } from '@angular/router';

//Componentes
import { HomeComponent } from './pages/home/home.component';
import { ListaTareasComponent } from './pages/lista-tareas/lista-tareas.component';
import { TareaComponent } from './pages/tarea/tarea.component';


const APP_ROUTES: Routes = [
  { path: '', component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: 'tareas', component: ListaTareasComponent },
  { path: 'tarea/:id', component: TareaComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'login'}
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
