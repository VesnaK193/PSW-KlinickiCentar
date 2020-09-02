import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LekarProfilDijalogComponent } from './lekar-profil-dijalog.component';

describe('LekarProfilDijalogComponent', () => {
  let component: LekarProfilDijalogComponent;
  let fixture: ComponentFixture<LekarProfilDijalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LekarProfilDijalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LekarProfilDijalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
