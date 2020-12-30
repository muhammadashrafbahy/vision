import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute,  Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { NgWizardConfig, NgWizardService, StepChangedArgs, StepValidationArgs, STEP_STATE, THEME } from 'ng-wizard';
import { NgxSpinnerService } from 'ngx-spinner';
import { of } from 'rxjs';
import { FileHandle } from 'src/app/core/shared/dragDrop.directive';
import { ProductService } from 'src/app/core/shared/services/product.service';
import { Brand } from '../../models/brand.model';
import { addBrandComponent } from '../add-brand/add-brand.component';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class addProductComponent implements OnInit {
  allBrand: Brand;
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
      showNextButton:false,
      showPreviousButton: false,
    }
  };
  
  productForm: FormGroup;
  submitted = false;
  step1Title:string = '';
  step2Title:string = '';
  step3Title:string = '';
  step4Title:string = '';
  prodTypeMainID = 0;
  addedProductId;
  files: FileHandle[] = [];



  constructor(private router: Router ,private route: ActivatedRoute,
    private formBuilder: FormBuilder,private ngWizardService: NgWizardService,
    private productService: ProductService,
    private spinner:NgxSpinnerService,
    private translate: TranslateService,
    private modalService: NgbModal) { 

      this.translate.get('Next').subscribe(val =>{         
        this.config.lang.next = val;
      });

      this.translate.get('addPhotos').subscribe(val =>{         
        this.step4Title = val;
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
      price: ['',[Validators.pattern(/^[0-9]\d*$/),Validators.maxLength(5),Validators.required]],
      desc:['', Validators.required]
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

    this.spinner.show();
    this.spinner.hide();

    this.showNextStep();
    this.productService.addProduct(this.productForm.value).subscribe(productId => {
      this.addedProductId = productId;


    });
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

showNextStep(event?: Event, callBackFunc?,CategoryType?) {
  this.ngWizardService.next();
  if (callBackFunc == 'getBrands') {
    this.getAllBrands();
    this.prodTypeMainID = CategoryType;

  }  
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

getAllBrands(){
  this.productService.getAllBrands().subscribe((brands:Brand) => {
    this.allBrand = brands;
    console.log(this.allBrand);
    
    
  })
}

filesDropped(files: FileHandle[]): void {
  this.files = files;
}

addPhotos(){
  const formData = new FormData();

  if (this.files) {
    this.spinner.show();
    this.files.forEach((element ,i ) => {
        console.log(element);
       formData.append('file', element+"");
       this.productService.addProductImgs(this.addedProductId , formData).subscribe(val => {
         
        if (i == this.files.length) {
          this.spinner.hide();
        }
       })

        
      });
  }
}
}
 
