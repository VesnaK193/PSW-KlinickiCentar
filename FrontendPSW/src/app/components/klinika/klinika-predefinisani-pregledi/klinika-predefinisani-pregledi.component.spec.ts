import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KlinikaPredefinisaniPreglediComponent } from './klinika-predefinisani-pregledi.component';

describe('KlinikaPredefinisaniPreglediComponent', () => {
  let component: KlinikaPredefinisaniPreglediComponent;
  let fixture: ComponentFixture<KlinikaPredefinisaniPreglediComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KlinikaPredefinisaniPreglediComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KlinikaPredefinisaniPreglediComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
