import { ComponentFixture, TestBed } from '@angular/core/testing';

import { singleProductComponent } from './single-product.component';

describe('singleProductComponent', () => {
  let component: singleProductComponent;
  let fixture: ComponentFixture<singleProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ singleProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(singleProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
