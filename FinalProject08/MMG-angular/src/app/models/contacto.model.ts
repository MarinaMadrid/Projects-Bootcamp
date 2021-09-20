export class Contacto {
  id: number;
  email: string;
  nombre: string;
  apellido: string;
  avatar: string;

  constructor(id: number, email: string, nombre: string, apellido: string, avatar: string){
      this.id = id;
      this.email = email;
      this.nombre = nombre;
      this.apellido = apellido
      this.avatar = avatar
  }
}
