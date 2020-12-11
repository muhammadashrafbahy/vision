import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute,  Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { NgWizardConfig, NgWizardService, StepChangedArgs, StepValidationArgs, STEP_STATE, THEME } from 'ng-wizard';
import { of } from 'rxjs';
import { addBrandComponent } from '../add-brand/add-brand.component';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class addProductComponent implements OnInit {
  stepStates = {
    normal: STEP_STATE.normal,
    disabled: STEP_STATE.disabled,
    error: STEP_STATE.error,
    hidden: STEP_STATE.hidden
  };
  NextValue:string ='';
  config: NgWizardConfig = {
    selected: 0,
    theme: THEME.dots,
    lang:{
      next:''
    },
    toolbarSettings: {
      showNextButton:true,
      showPreviousButton: false,
    }
  };
  
  productForm: FormGroup;
  submitted = false;
  step1Title:string = '';
  step2Title:string = '';
  step3Title:string = '';

  constructor(private router: Router ,private route: ActivatedRoute,
    private formBuilder: FormBuilder,private ngWizardService: NgWizardService,
    private translate: TranslateService,
    private modalService: NgbModal) { 

      this.translate.get('Next').subscribe(val =>{         
        this.config.lang.next = val;
      });

      this.translate.get('filter.Brand').subscribe(val =>{         
        this.step2Title = val;
      });
      this.translate.get('filter.Category').subscribe(val =>{         
        this.step1Title = val;
      });

      this.translate.get('filter.Product').subscribe(val =>{         
        this.step3Title = val;
      });



  }
  ngOnDestroy() {
   }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      name: ['', Validators.required],
      userName: [''],
      phone: ['', [ Validators.required , Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      email: ['', [  Validators.required , Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
      privilage: ['', Validators.required]
    })
   }

  // convenience getter for easy access to form fields
  get f() { return this.productForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.productForm.invalid) {
        return;
    }

    // display form values on success
    console.log('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
}
onReset() {
  this.submitted = false;
  this.productForm.reset();
}

isValidTypeBoolean: boolean = true;
 
isValidFunctionReturnsBoolean(args: StepValidationArgs) {
  return true;
}

isValidFunctionReturnsObservable(args: StepValidationArgs) {
  return of(true);
}


showPreviousStep(event?: Event) {
  this.ngWizardService.previous();
}

showNextStep(event?: Event) {
  this.ngWizardService.next();
}

resetWizard(event?: Event) {
  this.ngWizardService.reset();
}

setTheme(theme: THEME) {
  this.ngWizardService.theme(theme);
}

stepChanged(args: StepChangedArgs) {
  console.log(args.step);
}
openAddBrand(){
  const modalRef = this.modalService.open(addBrandComponent);

}

}
 
