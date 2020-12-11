  import { NgModule } from '@angular/core';
 
 import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ShopRoutingModule } from './shop-routing.module';
import { SharedModule } from '../core/shared/shared.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './components/home/home.component';
import { singleProductComponent } from './components/single-product/single-product.component';
import { CommonModule } from '@angular/common';
import { cartComponent } from './components/cart/cart.component';
import { checkoutComponent } from './components/checkout/checkout.component';
import { ResultComponent } from './components/result/result.component';
import { NgxGalleryModule } from 'ngx-gallery-9';


@NgModule({
  declarations: [
    HomeComponent,
    singleProductComponent,
    cartComponent,
    checkoutComponent,
    ResultComponent,
    
    ],
  imports: [
    ShopRoutingModule,
    CommonModule,
    NgbModule,
    NgbModule,
    SharedModule,
    NgxGalleryModule,
    // TranslateModule 

  ],
})
export class ShopModule { }
