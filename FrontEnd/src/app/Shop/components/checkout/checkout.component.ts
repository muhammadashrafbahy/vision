import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { NgWizardConfig, NgWizardService, StepChangedArgs, StepValidationArgs, STEP_STATE, THEME } from 'ng-wizard';
import { of } from 'rxjs';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss'],
  encapsulation:ViewEncapsulation.None
})
export class checkoutComponent implements OnInit {
  cartList = [];
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
      // toolbarExtraButtons: [
      //   { text: 'Finish', class: 'btn btn-info', event: () => { alert("Finished!!!"); } }
      // ],
      showNextButton:true,
      showPreviousButton: false,
    }
  };
 
  constructor(private _router:Router,private modalService:NgbModal,private ngWizardService: NgWizardService,
    private translate: TranslateService) {
       this.translate.get('Next').subscribe(val =>{         
          this.config.lang.next = val;
      });
     }
  
 
  ngOnInit(): void {
    this.cartList.push('s')
   
   }
   goToHome(){
     this._router.navigateByUrl('home')
   }


   showPreviousStep(event?: Event) {
    this.ngWizardService.previous();
  }
 
  showNextStep(event?: Event) {
    this.ngWizardService.next();
  }
 
  
 
 
 
  isValidTypeBoolean: boolean = true;
 
  isValidFunctionReturnsBoolean(args: StepValidationArgs) {
    return true;
  }
 
  isValidFunctionReturnsObservable(args: StepValidationArgs) {
    return of(true);
  }

   checkout(){
     let user = localStorage.getItem('user');
     this._router.navigateByUrl('/home/checkout')
    
   }

}
