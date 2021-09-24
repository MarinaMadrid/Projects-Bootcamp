import { HttpClientModule } from '@angular/common/http';
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';

import { TareasService } from 'src/app/services/tareas.service';
import { ListaTareasComponent } from './lista-tareas.component';
import { ListaServiceStub } from 'src/app/services/mocks/lista.service.mock.ts.component';

describe('ListaTareasComponent', () => {
  let component: ListaTareasComponent;
  let fixture: ComponentFixture<ListaTareasComponent>;
  let tarea:{
    id:2600,
    user_id:82,
    title: "Testing",
    due_on: "2021-09-23T00:00:00.000+05:30",
    status: "completed"
  };


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaTareasComponent ],
      imports: [
        HttpClientModule,
        FormsModule,
        RouterTestingModule,
        ReactiveFormsModule,
      ],
      providers: [
        {
          provide: TareasService
        }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaTareasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('Debería crear componente', () => {
    expect(component).toBeTruthy();
  });

  it('Debería aparecer h1', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Lista de tareas');
  });

  it('Se debe llamar a getTareasall del Servicio en ngOnInit', () => { //obtener todos las tareas que nos devuelve el servicio
    spyOn(component.tareasService, 'getTareasall').and.callThrough(); // Ponemos un espía a contar las veces que se llama al método
    component.ngOnInit(); // forzamos una llamada al método ngOnInit() del componente
    expect(component.tareasService.getTareasall).toHaveBeenCalledTimes(1); // Verificamos que se haya llamado a service.getTareasall() una vez

  });

  it('Debería obtener del servicio la lista de tareas y guardarla', waitForAsync( () => { //comprobar que cuando el componente está estable (ha ejecutado el ngOnInit) y está listo para poder acceder a todas sus propiedades, funciones, etc.
    //Se pueda verificar que tenemos la lista de alumnos en la propiedad adecuada
    // Cuando ya está estable, ya debería tener el listado de tareas
    fixture.whenStable().then(() => {
      expect(component.tareas.length).toBeGreaterThan(0); // Verificamos que no está vacía, es decir que su logitud es mayor que 0
    })
  }));

  it('Debería obtener del servicio la lista de tareas vacía', waitForAsync( () => {
    expect(component.tareas.length).toBeLessThanOrEqual(0);
  }));

  it('Debería renderizar la lista de tareas en el HTML', () => { //el componente pinta la lista de tareas obtenida correctamente en el HTML
    fixture.whenStable().then(() => {
      fixture.detectChanges() //Nos aseguramos de que la vista se actualice
      const elemento = fixture.debugElement.query(By.css('.tareas')).nativeElement; // Obetenemos un elemento del DOM que va a tener una clase .tareas donde va a estar la lista de tareas
      expect(elemento.childNodes[0]).not.toBeNull(); //Esperamos que DENTRO de .tareas haya al menos 1 nodo hijo (un elemento dentro)
    })
  });

  it('Debería llamar a eliminarTarea', () => {
    spyOn(component, 'eliminarTarea').and.callThrough();
    component.eliminarTarea(1);
    expect(component.eliminarTarea).toHaveBeenCalledTimes(1);
  });


  it('Debería borrar la tarea', () => {
    ListaServiceStub.nuevaTarea(tarea);
    let numListaTotal = ListaServiceStub.listaTareas.length;
    expect(ListaServiceStub.listaTareas.length).toBe(numListaTotal);
    ListaServiceStub.borrarTarea(tarea);
    expect(ListaServiceStub.listaTareas.length).toBeLessThan(numListaTotal);
  });

});
