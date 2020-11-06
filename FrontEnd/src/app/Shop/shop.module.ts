  import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

 import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ShopRoutingModule } from './shop-routing.module';
import { SharedModule } from '../core/shared/shared.module';
import { ProductsComponent } from './components/products/products.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    ProductsComponent
    ],
  imports: [
    CommonModule,
    ShopRoutingModule,

NgbModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
    SharedModule,
 

  ]
})
export class ShopModule { }
