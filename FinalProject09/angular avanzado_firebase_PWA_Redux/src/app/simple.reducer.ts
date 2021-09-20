import { Action } from "@ngrx/store"

export function simpleReducer( state: string = "Bienvenidos a la web del profesorado, meta su usuario y contraseña dada por el centro para poder acceder", action: Action){
    // console.log(action.type, state);

    switch (action.type){
        case 'Spanish':
            return state = 'Bienvenidos a la web del profesorado, meta su usuario y contraseña dada por el centro para poder acceder'
        case 'English':
            return state = 'Welcome to the teachers website, enter your username and password given by the center to be able to access'
        default:
            return state;
    }
}


