
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { Filesize } from './pipes/fileSize.pipe';
import { HttpClientModule } from '@angular/common/http';
import { TranslateModule } from '@ngx-translate/core';
import { ProductsComponent } from './components/products/products.component';
import { NgWizardConfig, NgWizardModule, THEME } from 'ng-wizard';
const ngWizardConfig: NgWizardConfig = {
  theme: THEME.default
  };
 
 
@NgModule({
  declarations: [ConfirmDialogComponent, Filesize , ProductsComponent ],
  imports: [
    CommonModule,
    ToastrModule.forRoot(),
    NgbModule,
    
    
    HttpClientModule,
    TranslateModule ,
    NgWizardModule.forRoot(ngWizardConfig),

  ],
  exports: [
    TranslateModule,
    ConfirmDialogComponent,
    ProductsComponent,
    NgWizardModule,
    FormsModule,
    ReactiveFormsModule,
    ],
  providers:[ Filesize ],
  entryComponents: [ ConfirmDialogComponent]
})
export class SharedModule { }