import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingDemoComponent } from './rating-demo.component';

describe('RatingDemoComponent', () => {
  let component: RatingDemoComponent;
  let fixture: ComponentFixture<RatingDemoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RatingDemoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RatingDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
