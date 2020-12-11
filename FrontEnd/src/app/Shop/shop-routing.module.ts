import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticationGuard } from '../core/services/authentication.guard';
import { cartComponent } from './components/cart/cart.component';
import { checkoutComponent } from './components/checkout/checkout.component';
import { HomeComponent } from './components/home/home.component';
import { ResultComponent } from './components/result/result.component';
import { singleProductComponent } from './components/single-product/single-product.component';
 

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path:'product/:id' ,
    
    component: singleProductComponent,
  },
  {
    path:'result' ,
    
    component: ResultComponent,
  },
  {
    path:'cart' ,
    
    component: cartComponent,
  },
  {
   path: 'checkout',
   canActivate: [AuthenticationGuard],
   component: checkoutComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopRoutingModule { }
