import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import {Injectable} from '@angular/core';
 import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import { BehaviorSubject, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  loggedUser = new BehaviorSubject(this.user);
  SERVER_URL:string = environment.SERVER_URL;
  constructor(
    
              private router: Router,
              private toastr: ToastrService,
              // private securityService: NgxSecurityService
              private httpClient:HttpClient
              ) {
                
          
  }

  login(userName: string, password: string) {
    let params = new URLSearchParams();
    params.append('username',userName);
    params.append('password',password);    
    params.append('grant_type','password');
    params.append('client_id','vision');
    let headers = 
      new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Basic '+btoa("vision:secret")});
    let options = { headers: headers };

    return this.httpClient.post(this.SERVER_URL + '/oauth/token',
    params.toString(),options);
  }

  // loadPermissions(funcs?:string, isAdmin?:boolean) {
  //   let functionalities = funcs? funcs:localStorage.getItem("functionalities")

  //   if (functionalities !== "undefined" && functionalities !== null) {
  //     let functionalitiesJson = JSON.parse(functionalities)
  //     functionalitiesJson.forEach( (func: Functionality) => {
  //       this.securityService.hasPermission(func.functionality.toUpperCase()).subscribe( permissionExists => {
  //         if (!permissionExists) {
  //           this.securityService.addPermission(func.functionality);
  //         }
  //       })
  //     })
  //   }

  //   //note for the 2 next conditions: the order is important, 
  //   //and it's done on 2 steps because it's called after login (isAdmin is true) and with refresh (isAdmin is undefined)
  //   if (isAdmin) { 
  //     localStorage.setItem("isAdmin", "true");
  //   } else {
  //     localStorage.setItem("isAdmin", "false");
  //   }

  //   if (localStorage.getItem("isAdmin") === "true") { //add role admin
  //     this.securityService.addRole("ADMIN");
  //   }
  // }

  logout() {
    this.loggedUser.next(null);
    localStorage.clear();
    this.router.navigate(['/']);
  }

  isLoggedIn(): boolean {
    // return this.alfrescoService.isLoggedIn();
    return true;
  }


 set user(value) {
   this.loggedUser.next(value); 
   localStorage.setItem('loggedUser', value);
 }

 get user() {
   return localStorage.getItem('loggedUser');
 }

}
