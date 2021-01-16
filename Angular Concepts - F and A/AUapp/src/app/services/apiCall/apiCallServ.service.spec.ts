/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ApiCallServService } from './apiCallServ.service';

describe('Service: ApiCallServ', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApiCallServService]
    });
  });

  it('should ...', inject([ApiCallServService], (service: ApiCallServService) => {
    expect(service).toBeTruthy();
  }));
});
