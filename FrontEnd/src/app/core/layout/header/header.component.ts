import { AuthenticationService } from './../../services/authentication.service';
import { Component, OnInit, HostListener, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit {

  public userName = '';
  public smallSideBarFlag: boolean;
  public searchBoxFlag = false;
  public searchText = '';
  public notifications = [];
  public userShortcuts = [];
  public windowWidth;
  public appDirection;
  public appLocale;
  @ViewChild('searchInput', {static: true}) searchInput: ElementRef;
  cartItem = [];

  constructor(private authService: AuthenticationService,
              // private store: Store<AppState> , 
              // private themeService: ThemeService,
              // private langService: LangService
              ) {

    // this.store.select('menu').subscribe(
    //   val => {
    //     this.smallSideBarFlag = val.menustate;
    //   }
    // );

    // this.appDirection = this.langService.appDirection;
    // this.appLocale = this.langService.appLocale;
  }

  ngOnInit() {
 
    this.userShortcuts.push(
      {
        name: 'Admin',
        icon: 'fa-user-cog',
        url: '/admin-tools',
      },
      {
        name: 'Reports',
        icon: 'fa-file-pdf',
        url: '#',
      },
      {
        name: 'Dashboard',
        icon: 'fa-tachometer-alt',
        url: '#',
      },

      {
        name: 'workflow',
        icon: 'fa-sitemap',
        url: '#',
      }
    );
   }


  toggleSearchBox = () => {
    this.searchBoxFlag = !this.searchBoxFlag;
    this.searchText = '';
  }

  logOut = () => {
    this.authService.logout();
  }

  // to get window Width
  @HostListener('window:resize', ['$event'])
  onResize(event) {

    window.innerWidth > 576 && window.innerWidth < 1199.98 ? this.windowWidth = true : this.windowWidth = false;
  }

  setGreenTheme() {

    // this.themeService.setGreenTheme();

  }

  changeLanguage(locale){
    // if (locale !== this.appLocale) {
    //   this.langService.setCurrentLang(locale);
    //   window.location.reload();
    // }

  }

}
