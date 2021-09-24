import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

import { TareasService } from 'src/app/services/tareas.service';
import { TareaComponent } from './tarea.component';
import { DebugElement, ElementRef } from '@angular/core';

describe('TareaComponent', () => {
  let component: TareaComponent;
  let fixture: ComponentFixture<TareaComponent>;
  let de: DebugElement;
  let buttonGuardar: ElementRef;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TareaComponent ],
      imports: [
        HttpClientModule,
        FormsModule,
        RouterTestingModule,
        ReactiveFormsModule
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
    fixture = TestBed.createComponent(TareaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    de = fixture.debugElement;
    buttonGuardar = de.query(By.css('#guardar'));
  });

  it('Debería crear componente', () => {
    expect(component).toBeTruthy();
  });

  it('Debería aparecer h1', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Crear tarea');
  });



});
