import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SystemConfigurationsService {

  constructor() {
  }

  isModelRequired(): boolean {
    // TODO this is dummy implementation until we implement the real logic
    return false;
  }

  isTypeRequired(): boolean {
    // TODO this is dummy implementation until we implement the real logic
    return this.isModelRequired() && false;
  }
}
