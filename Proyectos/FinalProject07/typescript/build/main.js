"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var lista_1 = require("./lista");
var producto_1 = require("./producto");
//Se crea la lista de la compra, la cual está vacía
var listaCompra = new lista_1.ListaCompra;
//Productos que añadir
var producto1 = new producto_1.Producto('chocolate', 1.35);
var producto2 = new producto_1.Producto('leche', 0.79);
var producto3 = new producto_1.Producto('galletas', 1.07);
var producto4 = new producto_1.Producto('macarrones', 0.70);
var producto5 = new producto_1.Producto('pizza', 2.85);
var producto6 = new producto_1.Producto("atún", 1.90);
//Se añaden los productos con la función "agregarNuevoProducto"
listaCompra.agregarNuevoProducto(producto1);
listaCompra.agregarNuevoProducto(producto2);
listaCompra.agregarNuevoProducto(producto3);
listaCompra.agregarNuevoProducto(producto4);
listaCompra.agregarNuevoProducto(producto5);
listaCompra.agregarNuevoProducto(producto6);
console.log("\nSe han a\u00F1adido los productos al carrito. \n");
//Se muestra la lista con todos los productos añadidos
listaCompra.mostrarListaCompra();
//Vamos a borrar el atún(producto6 y está en la posición 5(listaCompra[5]), por lo que su índice será 5
listaCompra.borrarProducto(5);
console.log(" \nSe ha quitado " + producto6.nombre + " del carrito. \n");
//Se muestra la lista con los productos añadidos y con el atún borrado
listaCompra.mostrarListaCompra();
//Vamos a calcular el precio total de lista de la compra
listaCompra.calcularPrecioTotal();
console.log("El precio total de la compra es: " + listaCompra.totalPrecio + " \u20AC.");
