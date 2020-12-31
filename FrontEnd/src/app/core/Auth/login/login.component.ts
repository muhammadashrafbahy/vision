import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from '../../services/authentication.service';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  model: any = {};

  constructor(private modalService:NgbModal, private _router: Router,
    private spinner: NgxSpinnerService,
    private authService: AuthenticationService,
    private toastr: ToastrService,
    ) { }

  ngOnInit(): void {
  }

  signInWithFB(){

  }
  login(loginForm){


    if (loginForm.invalid) {
      return;
    }
    this.spinner.show();

    this.authService.login( loginForm.value.userName.trim(), loginForm.value.password).subscribe(
      (data:any) => {
       this.spinner.hide();
        let user = {
          userName: loginForm.value.userName.trim(),
          token:data.access_token,
          type:'admin'
        }
        this.modalService.dismissAll();
        this._router.navigateByUrl('/administration');
        this.authService.user = JSON.stringify(user);
        
    }, error => {

      this.spinner.hide();
      this.toastr.error('Login failed please check user name or password');
      // console.log(error.error);
    })

  }

  
  goToRegister() {
    this.modalService.dismissAll();
    const modalRef = this.modalService.open(RegisterComponent);
  }
}
