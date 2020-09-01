import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminKComponent } from './admin-k.component';

describe('AdminKComponent', () => {
  let component: AdminKComponent;
  let fixture: ComponentFixture<AdminKComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminKComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminKComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
