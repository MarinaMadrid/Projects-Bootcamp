//import * as readline from 'readline-sync';
import {List} from './lista'
import {Product} from './producto'

//Productos
const chocolate = new Product('chocolate', 1.35)
const leche = new Product('leche', 0.79)
const galletas = new Product('galletas', 1.07)
const macarrones = new Product('macarrones', 0.70)
const pizza = new Product('pizza', 2.85)

function agregarNuevoProducto(producto: Product) {
    this.listado.push(producto);
}

function modificarProducto(indice: number, producto: Product) {
    this.listado[indice] = producto;
}

function mostrarListado(indice?: number) {
    if(indice) { console.log("El producto que necesitas comprar es: ", this.listado[indice]); }
    else { console.log("Los productos que necesitas comprar son: ", this.listado); }
}

function borrarProducto(indice:number) {
    this.borrar.emit(this.id)
}

function sumaPrecio(...valores:number[]) {
    let suma = 0;
    for(let x=0; x<valores.length; x++)
        suma+=valores[];
    return suma;
}