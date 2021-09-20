import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { VerComponent } from './ver.component';

describe('VerComponent', () => {
  let component: VerComponent;
  let fixture: ComponentFixture<VerComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ VerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
