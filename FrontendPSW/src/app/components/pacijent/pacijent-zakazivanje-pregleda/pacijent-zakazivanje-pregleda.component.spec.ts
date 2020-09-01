import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentZakazivanjePregledaComponent } from './pacijent-zakazivanje-pregleda.component';

describe('PacijentZakazivanjePregledaComponent', () => {
  let component: PacijentZakazivanjePregledaComponent;
  let fixture: ComponentFixture<PacijentZakazivanjePregledaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentZakazivanjePregledaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentZakazivanjePregledaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
