import { TestBed } from '@angular/core/testing';

import { HadifMediaService } from './media.service';

describe('HadifMediaService', () => {
  let service: HadifMediaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HadifMediaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
