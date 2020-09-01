import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminKProfilDijalogComponent } from './admin-k-profil-dijalog.component';

describe('AdminKProfilDijalogComponent', () => {
  let component: AdminKProfilDijalogComponent;
  let fixture: ComponentFixture<AdminKProfilDijalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminKProfilDijalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminKProfilDijalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
