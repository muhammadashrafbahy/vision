import { AuthenticationService } from './../../services/authentication.service';
import { Component, OnInit, HostListener, ViewChild, ElementRef } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
 import { LangService } from '../../shared/langs/lang-service';
import { LoginComponent } from '../../Auth/login/login.component';
import { RegisterComponent } from '../../Auth/register/register.component';
import { Router } from '@angular/router';
 

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit {

  public userName = '';
  public searchBoxFlag = false;
  public searchText = '';
  public notifications = [];
  public userShortcuts = [];
  public windowWidth;
  public appDirection;
  public appLocale;
  @ViewChild('searchInput', {static: true}) searchInput: ElementRef;
  cartItem = [];
  user;

  constructor(private authService: AuthenticationService,
              // private store: Store<AppState> , 
              // private themeService: ThemeService,
              private langService: LangService,
              private modalService: NgbModal,
              private _router:Router
              ) {

  
    this.appDirection = this.langService.appDirection;
    this.appLocale = this.langService.appLocale;
  }

  ngOnInit() {
    this.authService.loggedUser.subscribe(loggedUser => {
      this.user = JSON.parse(loggedUser);
    })
    
   }




  logOut = () => {
    this.authService.logout();
  }


  changeLanguage(locale){
    if (locale !== this.appLocale) {
      this.langService.setCurrentLang(locale);
      window.location.reload();
    }

  }

    // open login
    openLogin() {
      const modalRef = this.modalService.open(LoginComponent);

    }

    // open register
    openRegister() {
    const modalRef = this.modalService.open(RegisterComponent);

  }

  search(){
    this._router.navigateByUrl('/home/result?searchKey='+this.searchText)
  }
}