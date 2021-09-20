import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { RouterModule } from '@angular/router';
import { ROUTES } from './app.routing';

import { HomeComponent } from './paginas/home/home.component';
import { ErrorComponent } from './componentes/error/error.component';
import { PieComponent } from './componentes/pie/pie.component';
import { CabeceraComponent } from './componentes/cabecera/cabecera.component';
import { LoginComponent } from './componentes/login/login.component';
import { AlumnoComponent } from './paginas/alumno/alumno.component';
import { VerComponent } from './paginas/ver/ver.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

//PWA
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';

//Reducer
import { StoreModule } from '@ngrx/store';
import { simpleReducer } from './simple.reducer';  //creado por nosotros

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ErrorComponent,
    PieComponent,
    CabeceraComponent,
    LoginComponent,
    AlumnoComponent,
    VerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production }),
    RouterModule.forRoot( ROUTES, { useHash: true } ),
    StoreModule.forRoot({mesagge: simpleReducer})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
