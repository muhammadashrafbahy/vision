import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  model: any = {};

  constructor(private modalService:NgbModal, private _router: Router) { }

  ngOnInit(): void {
  }

  signInWithFB(){

  }
  login(loginForm){
    if (loginForm.value.mail =='admin' && loginForm.value.password =='admin') {
      this._router.navigateByUrl('/administration');
      this.modalService.dismissAll();
    }
    

  }

  
  goToRegister() {
    this.modalService.dismissAll();
    const modalRef = this.modalService.open(RegisterComponent);
  }
}
