import {ListaCompra} from './lista';
import {Producto} from './producto';

//Se crea la lista de la compra, la cual está vacía
let listaCompra: ListaCompra = new ListaCompra;

//Productos que añadir
let producto1:Producto = new Producto('chocolate', 1.35);
let producto2:Producto = new Producto('leche', 0.79);
let producto3:Producto = new Producto('galletas', 1.07);
let producto4:Producto = new Producto('macarrones', 0.70);
let producto5:Producto = new Producto('pizza', 2.85);
let producto6:Producto = new Producto("atún", 1.90);

//Se añaden los productos con la función "agregarNuevoProducto"
listaCompra.agregarNuevoProducto(producto1);
listaCompra.agregarNuevoProducto(producto2);
listaCompra.agregarNuevoProducto(producto3);
listaCompra.agregarNuevoProducto(producto4);
listaCompra.agregarNuevoProducto(producto5);
listaCompra.agregarNuevoProducto(producto6);
console.log(`\nSe han añadido los productos al carrito. \n`)

//Se muestra la lista con todos los productos añadidos
listaCompra.mostrarListaCompra();

//Vamos a borrar el atún(producto6 y está en la posición 5(listaCompra[5]), por lo que su índice será 5
listaCompra.borrarProducto(5);
console.log(` \nSe ha quitado ${producto6.nombre} del carrito. \n`)

//Se muestra la lista con los productos añadidos y con el atún borrado
listaCompra.mostrarListaCompra();

//Vamos a calcular el precio total de lista de la compra
listaCompra.calcularPrecioTotal();
console.log(`El precio total de la compra es: ${listaCompra.totalPrecio} €.`)