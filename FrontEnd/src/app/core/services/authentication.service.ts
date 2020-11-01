import {Injectable} from '@angular/core';
 import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
// import { NgxSecurityService } from 'ngx-security';
// import { Functionality } from '@alf-core/models/functionality.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    
              private router: Router,
              private toastr: ToastrService,
              // private securityService: NgxSecurityService
              ) {
  }

  login(userId: string, password: string) {
    // return this.alfrescoService.login(userId, password);
    return true
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
    // this.alfrescoService.logout().then(error => {

    //   localStorage.clear();
    // });
    // this.securityService.reset();
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    // return this.alfrescoService.isLoggedIn();
    return true;
  }
}
