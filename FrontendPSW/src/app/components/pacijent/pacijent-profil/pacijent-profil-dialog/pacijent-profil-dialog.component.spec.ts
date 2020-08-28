import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentProfilDialogComponent } from './pacijent-profil-dialog.component';

describe('PacijentProfilDialogComponent', () => {
  let component: PacijentProfilDialogComponent;
  let fixture: ComponentFixture<PacijentProfilDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentProfilDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentProfilDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
