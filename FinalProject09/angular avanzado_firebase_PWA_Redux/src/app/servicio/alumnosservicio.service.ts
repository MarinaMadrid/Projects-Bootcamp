import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AlumnosModel } from '../models/alumnos.model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AlumnosServicio {

  //Base de datos
  private url = 'https://proyectoangularavanzado-default-rtdb.europe-west1.firebasedatabase.app/';

  //Login
  private url2 = 'https://identitytoolkit.googleapis.com/v1/accounts:sign';

  private apikey = 'AIzaSyCSjcbVcGDw8ulihtan3ipiDZjDxll72_4';                 

usartoken: string;

  constructor( private http: HttpClient ) { 
    this.leertoken(); 
  }

  getTodosElementos(){                                                     
  
    return this.http.get(`${ this.url }/alumnos.json`).pipe( map( this.variableCrearArreglo 
    ));
  }
  private variableCrearArreglo ( resp: object ){                  
  
  const mostrarTodos: AlumnosModel[] = [];                                     
  console.log(resp);
  
  if ( resp === null ) {                                        
    return [];
  }
  
  Object.keys( resp ).forEach( key => {               
  const obj: AlumnosModel = resp[key];
  obj.id = key;                                     
  
  mostrarTodos.push( obj );
  } );
  
    return mostrarTodos;                                                   
  }


  getUnElemento(id:string){                                                       
    return this.http.get(`${ this.url }/alumnos/${ id }.json`); 
  }

  borrarElemento( id: string ){                                              

    return this.http.delete(`${ this.url }/alumnos/${ id }.json`);   
  }



  crearalumnos ( nuevoalumnos: AlumnosModel ){                   
    return this.http.post(`${ this.url }/alumnos.json`, nuevoalumnos).pipe(    
        map( ( respuesta: any ) => {                    
          nuevoalumnos.id = respuesta.name;               
            return nuevoalumnos;                             
        })
      );
  }

  actualizaralumnos( actualizaralumnos: AlumnosModel ){                                              

    const id = {                                                                   
        ...actualizaralumnos
      };
  
      delete id.id;                                                                       
  
      return this.http.put(`${ this.url }/alumnos/${ actualizaralumnos.id }.json`, id)         
  }






  login (usuario: AlumnosModel){

    const login = {                     
        ...usuario,
        returnSecureToken: true
      };
    
    return this.http.post(this.url2 + 'InWithPassword?key=' + this.apikey, login).pipe(map( resp => {       
      // console.log ('Entro en el mapa del RXJS');                                                                       
      this.guardartoken( resp['idToken'] );                                                                            
      return resp;
        })
        );   

    }

    logout(){
      localStorage.removeItem('token');                                   
    }
    
    private guardartoken (idToken: string){                            
      this.usartoken = idToken;
        localStorage.setItem('token', idToken);                                 
      
      let hoy = new Date();                                                  
      hoy.setSeconds( 3600 );                                                 
      localStorage.setItem('variableExpira', hoy.getTime().toString() );      
      }
      
      leertoken(){
        if (localStorage.getItem('token')){
          this.usartoken=localStorage.getItem('token');                         
          }else{
          this.usartoken='';                                                    
          }
        return this.usartoken;
        }

        guardEstaAutentificado(): boolean{                                 
          if ( this.usartoken.length < 2 ){                               
            return false;
          }
        
          const variableExpira = Number (localStorage.getItem('variableExpira'));     
          const variableExpira2 = new Date();                                         
            variableExpira2.setTime(variableExpira);                                   
        
              if ( variableExpira2 > new Date() ){                                   
                return true;                                                            
                  }else{
              return false;                                                           
            }
        }



      

}
