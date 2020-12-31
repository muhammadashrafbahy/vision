import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute,  Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { NgWizardConfig, NgWizardService, StepChangedArgs, StepValidationArgs, STEP_STATE, THEME } from 'ng-wizard';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { of } from 'rxjs';
import { ProductService } from 'src/app/core/shared/services/product.service';
import { Brand } from '../../models/brand.model';

@Component({
  selector: 'app-add-brand',
  templateUrl: './add-brand.component.html',
  styleUrls: ['./add-brand.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class addBrandComponent implements OnInit {
  
  brandForm: FormGroup;
  submitted = false;
  brand;
  fileName='';


  constructor(private router: Router ,private route: ActivatedRoute,
    private formBuilder: FormBuilder,private ngWizardService: NgWizardService,
    private productService: ProductService,
    private spinner: NgxSpinnerService,
    private toastr: ToastrService,
    private translate: TranslateService) { 

     
  }
  ngOnDestroy() {
   }

  ngOnInit(): void {
    this.brandForm = this.formBuilder.group({
      name: ['', Validators.required],
      logo: ['', Validators.required],
      desc: [''],
    })
   }

  // convenience getter for easy access to form fields
  get f() { return this.brandForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.brandForm.invalid) {
        return;
    }
    this.spinner.show();
    // this.brand.brandName = this.f.name.value;
    // this.brand.logo = this.f.logo.value;
    // this.brand.description = this.f.desc.value;
    const formData = new FormData();

    formData.append('file', this.f.logo.value);
    var brandJson = {
      'Name':this.f.name.value ,
      'description': this.f.desc.value,
    }
    formData.append('brandJson',JSON.stringify(brandJson));

    this.productService.addBrand(formData).subscribe(res => {
      this.spinner.hide();
      this.toastr.success('Success Adding New Brand','Vision');


    })
}
  
onReset() {
  this.submitted = false;
  this.brandForm.reset();
}

onFileChange(event) {
  
  if (event.target.files.length > 0) {
    const file = event.target.files[0];
    this.fileName = file.name;    
    this.brandForm.patchValue({
      logo: file
    });
  }
}
}
 
