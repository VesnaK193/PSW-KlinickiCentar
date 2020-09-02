import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminKProfilKlinikeComponent } from './admin-k-profil-klinike.component';

describe('AdminKProfilKlinikeComponent', () => {
  let component: AdminKProfilKlinikeComponent;
  let fixture: ComponentFixture<AdminKProfilKlinikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminKProfilKlinikeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminKProfilKlinikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
