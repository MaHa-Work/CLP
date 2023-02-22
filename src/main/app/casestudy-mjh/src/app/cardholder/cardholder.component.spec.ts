import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardholderComponent } from './cardholder.component';

describe('CardholderComponent', () => {
  let component: CardholderComponent;
  let fixture: ComponentFixture<CardholderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardholderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardholderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
