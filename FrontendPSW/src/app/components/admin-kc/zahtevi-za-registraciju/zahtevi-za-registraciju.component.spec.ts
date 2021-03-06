import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZahteviZaRegistracijuComponent } from './zahtevi-za-registraciju.component';

describe('ZahteviZaRegistracijuComponent', () => {
  let component: ZahteviZaRegistracijuComponent;
  let fixture: ComponentFixture<ZahteviZaRegistracijuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZahteviZaRegistracijuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZahteviZaRegistracijuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
