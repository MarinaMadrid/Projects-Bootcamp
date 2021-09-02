export class Producto {
    constructor(
        private _nombre:string,
        private _precio:number
        ) {}
    
    toString(){
        return `Producto: {nombre: ${this.nombre}, precio: ${this.precio}}`;
    }

    //Get and set
    get nombre():string{
        return this._nombre;
    }

    set nombre(nuevoNombre:string){
        this._nombre = nuevoNombre;
    }

    get precio():number{
        return this._precio;
    }

    set precio(nuevoPrecio:number){
        this._precio = nuevoPrecio;
    }
}

//Producto por defecto
export const defaultProduct = new Producto(
    'producto',
    0
)