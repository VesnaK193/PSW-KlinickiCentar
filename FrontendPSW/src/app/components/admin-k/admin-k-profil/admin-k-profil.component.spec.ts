import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminKProfilComponent } from './admin-k-profil.component';

describe('AdminKProfilComponent', () => {
  let component: AdminKProfilComponent;
  let fixture: ComponentFixture<AdminKProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminKProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminKProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
