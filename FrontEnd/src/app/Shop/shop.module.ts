  import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

 import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ShopRoutingModule } from './shop-routing.module';

@NgModule({
  declarations: [
    ],
  imports: [
    CommonModule,
    ShopRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule


  ]
})
export class ShopModule { }
