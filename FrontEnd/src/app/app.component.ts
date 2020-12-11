import { Component } from '@angular/core';
import { LangService } from './core/shared/langs/lang-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'visionAPP';

  constructor(private langService: LangService){
    this.langService.setCurrentLang(this.langService.getCurrentLang())

  }
}
