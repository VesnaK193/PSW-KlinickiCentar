import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KlinikaLekariComponent } from './klinika-lekari.component';

describe('KlinikaLekariComponent', () => {
  let component: KlinikaLekariComponent;
  let fixture: ComponentFixture<KlinikaLekariComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KlinikaLekariComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KlinikaLekariComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
