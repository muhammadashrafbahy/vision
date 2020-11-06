
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
 import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { Filesize } from './pipes/fileSize.pipe';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [ConfirmDialogComponent, Filesize],
  imports: [
    CommonModule,
    ToastrModule.forRoot(),
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
     ConfirmDialogComponent],
  providers:[ Filesize],
  entryComponents: [ ConfirmDialogComponent]
})
export class SharedModule { }