import { Injectable } from "@angular/core";
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: "root"
})
export class LangService {
  appLang = 'English';
  appLocale = 'en';
  appDirection ='ltr';

  getCurrentLang() {
    return  localStorage.getItem('lang') ? localStorage.getItem('lang')  :'en';
  }

  constructor(private translate:TranslateService){
    
  }
  //ar >> arabic
  //en >> english
setCurrentLang(lang:string): void {
   localStorage.setItem('lang',lang);
   this.translate.use(lang);
   let htmlEle = document.getElementsByTagName('html')[0];
   if (lang === 'ar') {
    htmlEle.setAttribute('dir', 'rtl');
    this.appLang = 'عربى';
    this.appDirection = 'rtl';
    this.appLocale='ar';
    htmlEle.classList.add('ar');
   }else{
    htmlEle.setAttribute('dir', 'ltr');
   }
  }
}
