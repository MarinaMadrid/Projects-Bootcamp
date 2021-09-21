import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TareacrearComponent } from './tareacrear.component';

describe('TareacrearComponent', () => {
  let component: TareacrearComponent;
  let fixture: ComponentFixture<TareacrearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TareacrearComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TareacrearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
