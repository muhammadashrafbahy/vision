import { TestBed } from '@angular/core/testing';

import { SystemConfigurationsService } from './system-configurations.service';

describe('SystemConfigurationsService', () => {
  let service: SystemConfigurationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SystemConfigurationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
