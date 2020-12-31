import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationGuard } from '../../services/authentication.guard';
import { AuthenticationService } from '../../services/authentication.service';
import { MustMatch } from '../../shared/mustMatch.validator';
import { Client } from '../models/client.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
private client:Client;
submitted = false;
registerForm: FormGroup;

  constructor(private spinner: NgxSpinnerService,private authService:AuthenticationService,
     private formBuilder: FormBuilder,
    private  toastr:ToastrService,
    private modalService:NgbModal
     ) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      userName: ['', Validators.required],
      // userName: [''],
      phone: ['', [ Validators.required , Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      email: ['', [  Validators.required , Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
  }, {
      validator: MustMatch('password', 'confirmPassword')
  });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }
  
  signInWithFB(){

  }
  onSubmit(){
  //  debugger
    
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    this.spinner.show();
    
    this.client = new Client();
    this.client.clientName =  this.f.userName.value;
    this.client.phone =  this.f.phone.value;
    this.client.clientEmail =  this.f.email.value;
    this.client.clientPassword =  this.f.password.value;




    this.authService.registerClient(this.client).subscribe(data => {
        this.authService.login( this.f.userName.value, this.f.password.value).subscribe((user:any) => {
         
          this.toastr.success('Done Created','Vision');
          /*TODO: user type*/ 
          let loggedUser = {
            userName:  this.f.userName.value,
            token:user.access_token,
            type:'admin'
          }
          this.modalService.dismissAll();
          /*validate if user or clint and come from whrer*/
          this.authService.user = JSON.stringify(loggedUser);

          this.spinner.hide();
          
        })
        
    })
  }
  goToLogin(){}
 
}
