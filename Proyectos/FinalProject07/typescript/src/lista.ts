import {Producto, defaultProduct} from './producto'

export class ListaCompra {
    //Variable carrito, que es una lista de productos
    carrito: Producto[] = [];

    constructor(
        private _producto:Producto = defaultProduct,
        private _totalPrecio:number = 0
    ) {}
    
    //Get y set
    get producto():Producto{
        return this._producto;
    }

    set producto(nuevoProducto:Producto){
        this._producto = nuevoProducto;
    }

    get suma():number{
        return this._totalPrecio;
    }

    set suma(nuevoTotalPrecio:number){
        this._totalPrecio = nuevoTotalPrecio;
    }

    //Función para añadir productos
    agregarNuevoProducto(producto:Producto) {
        this.carrito.push(producto);
    }


    //Función para mostrar la lista de la compra
    mostrarListaCompra() {
        console.log("Los productos que vas a comprar son: ")
        for (let producto of this.carrito){
            console.log(producto.toString(),"\n");
        }    
    }
    
    //Función para borrar un producto, introduciendo su posición en la lista
    borrarProducto(indice:number) {
        this.carrito.splice(indice,1);
    }
    
    //Función para sumar los precios de los productos
    calcularPrecioTotal() {
        this.carrito.forEach((_producto) => {this._totalPrecio += _producto.precio});
        return this._totalPrecio;
    }
}