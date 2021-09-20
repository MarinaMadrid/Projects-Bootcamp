import { Routes, CanActivate  } from '@angular/router';

import { AppComponent } from './app.component';

import { HomeComponent } from './paginas/home/home.component';
import { ErrorComponent } from './componentes/error/error.component';
import { PieComponent } from './componentes/pie/pie.component';
import { CabeceraComponent } from './componentes/cabecera/cabecera.component';
import { LoginComponent } from './componentes/login/login.component';

import { LoginguardGuard } from './componentes/login/guard/loginguard.guard';

import { AlumnoComponent } from './paginas/alumno/alumno.component';
import { VerComponent } from './paginas/ver/ver.component';

export const ROUTES: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [LoginguardGuard]},
  { path: 'pie', component: PieComponent},
  { path: 'cabecera', component: CabeceraComponent},
  { path: 'appcomponente', component: AppComponent },
  { path: 'login', component: LoginComponent },
  { path: 'pedir/:id', component: AlumnoComponent, canActivate: [LoginguardGuard] },
  { path: 'ver/:id', component: VerComponent, canActivate: [LoginguardGuard] },
  { path: '**', component: ErrorComponent}
];


