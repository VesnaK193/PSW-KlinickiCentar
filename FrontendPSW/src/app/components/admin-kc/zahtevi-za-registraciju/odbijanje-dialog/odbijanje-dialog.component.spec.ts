import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OdbijanjeDialogComponent } from './odbijanje-dialog.component';

describe('OdbijanjeDialogComponent', () => {
  let component: OdbijanjeDialogComponent;
  let fixture: ComponentFixture<OdbijanjeDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OdbijanjeDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OdbijanjeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
