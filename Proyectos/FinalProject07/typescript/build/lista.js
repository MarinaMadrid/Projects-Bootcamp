"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ListaCompra = void 0;
var producto_1 = require("./producto");
var ListaCompra = /** @class */ (function () {
    function ListaCompra(_producto, _totalPrecio) {
        if (_producto === void 0) { _producto = producto_1.defaultProduct; }
        if (_totalPrecio === void 0) { _totalPrecio = 0; }
        this._producto = _producto;
        this._totalPrecio = _totalPrecio;
        //Variable carrito, que es una lista de productos
        this.carrito = [];
    }
    Object.defineProperty(ListaCompra.prototype, "producto", {
        //Get y set
        get: function () {
            return this._producto;
        },
        set: function (nuevoProducto) {
            this._producto = nuevoProducto;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(ListaCompra.prototype, "totalPrecio", {
        get: function () {
            return this._totalPrecio;
        },
        set: function (nuevoTotalPrecio) {
            this._totalPrecio = nuevoTotalPrecio;
        },
        enumerable: false,
        configurable: true
    });
    //Función para añadir productos
    ListaCompra.prototype.agregarNuevoProducto = function (producto) {
        this.carrito.push(producto);
    };
    //Función para mostrar la lista de la compra
    ListaCompra.prototype.mostrarListaCompra = function () {
        console.log("Los productos que vas a comprar son: ");
        for (var _i = 0, _a = this.carrito; _i < _a.length; _i++) {
            var producto = _a[_i];
            console.log(producto.toString(), "\n");
        }
    };
    //Función para borrar un producto, introduciendo su posición en la lista
    ListaCompra.prototype.borrarProducto = function (indice) {
        this.carrito.splice(indice, 1);
    };
    //Función para sumar los precios de los productos
    ListaCompra.prototype.calcularPrecioTotal = function () {
        var _this = this;
        this.carrito.forEach(function (_producto) { _this._totalPrecio += _producto.precio; });
        return this._totalPrecio;
    };
    return ListaCompra;
}());
exports.ListaCompra = ListaCompra;
