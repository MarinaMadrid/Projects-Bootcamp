import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HomeComponent } from './home.component';



describe('homeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeComponent ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('Debería crear componente', () => {
    expect(component).toBeTruthy();
  });

});
