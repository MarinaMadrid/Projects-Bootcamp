export class Tarea {
    id: number;
    user_id: number;
    title: string;
    due_on: string;
    status: string;

    constructor(id: number, user_id: number, title: string, due_on: string, status: string){

    this.id = id;
    this.user_id = user_id;
    this.title = title;
    this.due_on = due_on;
    this.status = status;
  }
}
