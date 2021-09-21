import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TareaactualizarComponent } from './tareaactualizar.component';

describe('TareaactualizarComponent', () => {
  let component: TareaactualizarComponent;
  let fixture: ComponentFixture<TareaactualizarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TareaactualizarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TareaactualizarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
