import { TestBed } from '@angular/core/testing';

import { CanActivateViaAuthGuard } from './can-activate-via-auth.guard';

describe('CanActivateViaAuthGuard', () => {
  let guard: CanActivateViaAuthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CanActivateViaAuthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
