import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute,  Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class addUserComponent implements OnInit {
  
  registerForm: FormGroup;
  submitted = false;
  constructor(private router: Router ,private route: ActivatedRoute
    ,private formBuilder: FormBuilder) { 

  }
  ngOnDestroy() {
   }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      userName: [''],
      phone: ['', [ Validators.required , Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      email: ['', [  Validators.required , Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
      privilage: ['', Validators.required]
  }, {
      validator: MustMatch('password', 'confirmPassword')
  });
   }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }

    // display form values on success
    console.log('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
}
onReset() {
  this.submitted = false;
  this.registerForm.reset();
}

}
 


  // custom validator to check that two fields match
  export function MustMatch(controlName: string, matchingControlName: string) {
      return (formGroup: FormGroup) => {
          const control = formGroup.controls[controlName];
          const matchingControl = formGroup.controls[matchingControlName];
  
          if (matchingControl.errors && !matchingControl.errors.mustMatch) {
              // return if another validator has already found an error on the matchingControl
              return;
          }
  
          // set error on matchingControl if validation fails
          if (control.value !== matchingControl.value) {
              matchingControl.setErrors({ mustMatch: true });
          } else {
              matchingControl.setErrors(null);
          }
      }
  }