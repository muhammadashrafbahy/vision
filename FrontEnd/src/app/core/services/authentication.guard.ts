import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs';
import { LoginComponent } from '../Auth/login/login.component';
// import { AuthenticationService } from '@alf-core/services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationGuard implements CanActivate {
  constructor(private router: Router,
    private modalService:NgbModal
    // private authService: AuthenticationService
    ) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(true){
      // if (this.authService.isLoggedIn()) {
      // logged in so return true
      return true;
    } else {
      // not logged in so redirect to login page with the return url
      this.modalService.open(LoginComponent);
      this.router.navigate(['/home'], { queryParams: { returnUrl: state.url } });
      return false;
    }
  }
}
