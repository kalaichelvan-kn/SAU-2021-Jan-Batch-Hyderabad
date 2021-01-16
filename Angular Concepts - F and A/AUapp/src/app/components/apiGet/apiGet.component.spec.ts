/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { ApiGetComponent } from './apiGet.component';

describe('ApiGetComponent', () => {
  let component: ApiGetComponent;
  let fixture: ComponentFixture<ApiGetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApiGetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApiGetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
