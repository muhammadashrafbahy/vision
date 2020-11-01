import { Injectable } from "@angular/core";

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

  //ar >> arabic
  //en >> english
setCurrentLang(lang:string): void {
   localStorage.setItem('lang',lang);
   let htmlEle = document.getElementsByTagName('html')[0];
   if (lang === 'ar') {
    htmlEle.setAttribute('dir', 'rtl');
    this.appLang = 'عربى';
    this.appDirection = 'rtl';
    this.appLocale='ar';
   }else{
    htmlEle.setAttribute('dir', 'ltr');
   }
  }
}
