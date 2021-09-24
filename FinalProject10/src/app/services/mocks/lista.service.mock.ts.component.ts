import { Tarea } from "src/app/models/tarea.model";


export class ListaServiceStub{


 static listaTareas= [
    {
    id:106,
    user_id:82,
    title: "Theatrum aufero beatae damno cognomen territo cohors tollo sum usus.",
    due_on: "2021-10-03T00:00:00.000+05:30",
    status: "completed"
  },
  {
    id:107,
    user_id:82,
    title: "Conicio minus sopor confero at conservo calculus.",
    due_on: "2021-10-01T00:00:00.000+05:30",
    status: "completed"
  },
  {
    id:108,
    user_id:82,
    title: "Pel usus suggero agnitio audacia copiose commodi acies.",
    due_on: "2021-10-01T00:00:00.000+05:30",
    status: "pending"
  }];


  static nuevaTarea(tarea: Tarea) {
    ListaServiceStub.listaTareas.push(tarea);

  }


  static borrarTarea(tarea: Tarea) {

    ListaServiceStub.listaTareas.forEach((element) => {
        ListaServiceStub.listaTareas.splice(ListaServiceStub.listaTareas.indexOf(element), 1);

    });
  }

}

