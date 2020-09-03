import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentKlinikeComponent } from './pacijent-klinike.component';

describe('PacijentKlinikeComponent', () => {
  let component: PacijentKlinikeComponent;
  let fixture: ComponentFixture<PacijentKlinikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentKlinikeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentKlinikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
