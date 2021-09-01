import {Product, defaultProduct} from './producto'

export class List {
    listado: Product[] = [];

    constructor(
        private _producto:Product = defaultProduct,
        private _sumaPrecio:number = 50
    ) {}

    toString(){
        return `Lista: {producto: ${this._producto.toString()}}, total: ${this._sumaPrecio}}`
    }
    //PUEDEN SALIR MUCHOS TOTAL???

    get producto():Product{
        return this._producto;
    }

    set producto(nuevoProducto:Product){
        this._producto = nuevoProducto;
    }

    get suma():number{
        return this._sumaPrecio;
    }

    set suma(nuevaSuma:number){
        this._sumaPrecio = nuevaSuma;
    }
}