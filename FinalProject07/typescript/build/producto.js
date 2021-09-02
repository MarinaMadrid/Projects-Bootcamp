"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.defaultProduct = exports.Producto = void 0;
var Producto = /** @class */ (function () {
    function Producto(_nombre, _precio) {
        this._nombre = _nombre;
        this._precio = _precio;
    }
    Producto.prototype.toString = function () {
        return "Producto: {nombre: " + this.nombre + ", precio: " + this.precio + "}";
    };
    Object.defineProperty(Producto.prototype, "nombre", {
        //Get and set
        get: function () {
            return this._nombre;
        },
        set: function (nuevoNombre) {
            this._nombre = nuevoNombre;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Producto.prototype, "precio", {
        get: function () {
            return this._precio;
        },
        set: function (nuevoPrecio) {
            this._precio = nuevoPrecio;
        },
        enumerable: false,
        configurable: true
    });
    return Producto;
}());
exports.Producto = Producto;
//Producto por defecto
exports.defaultProduct = new Producto('producto', 0);
