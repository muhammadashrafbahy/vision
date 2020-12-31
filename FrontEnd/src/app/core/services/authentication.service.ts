import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import {Injectable} from '@angular/core';
 import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import { BehaviorSubject, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../Auth/models/client.model';

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
    // params.append('client_id','vision');
    let headers = 
      new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Basic '+btoa("vision:secret")});
    let options = { headers: headers };

    return this.httpClient.post(this.SERVER_URL + 'login',
    params.toString(),options);
  }

  registerClient(client:Client){
    return this.httpClient.post(this.SERVER_URL + 'register/client',client);
  }
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
