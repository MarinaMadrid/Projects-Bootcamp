export class Product {
    constructor(
        private _nombre:string,
        private _precio:number
        ) {}
    
    toString(){
        return `Producto: {nombre: ${this.nombre}, precio: ${this.precio}}`;
    }

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

export const defaultProduct = new Product(
    'name',
    2.50
)