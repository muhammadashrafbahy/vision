import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { NgWizardConfig, NgWizardService, StepChangedArgs, StepValidationArgs, STEP_STATE, THEME } from 'ng-wizard';
import { of } from 'rxjs';
import { addUserComponent } from '../../components/add-user/add-user.component';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
  encapsulation:ViewEncapsulation.None
})
export class usersComponent implements OnInit {
  
  constructor(private _router:Router,private modalService:NgbModal,private ngWizardService: NgWizardService,
    private translate: TranslateService) {
       
     }
  
 
  ngOnInit(): void {
    
   }
   goToHome(){
     this._router.navigateByUrl('home')
   }

   openAddUserModel(){
    const modalRef = this.modalService.open(addUserComponent);

   }
   
  
}
