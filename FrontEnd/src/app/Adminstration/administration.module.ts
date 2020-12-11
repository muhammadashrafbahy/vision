  import { NgModule } from '@angular/core';
 
 import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedModule } from '../core/shared/shared.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { AdministrationRoutingModule } from './administration-routing.module';
import { addUserComponent } from './components/add-user/add-user.component';
import { HomeAdminComponent } from './pages/home/homeAdmin.component';
import { adminProductsComponent } from './pages/adminProducts/adminProducts.component';
import { addProductComponent } from './components/add-product/add-product.component';
import { addBrandComponent } from './components/add-brand/add-brand.component';

@NgModule({
  declarations: [
    addUserComponent,
    HomeAdminComponent,
    adminProductsComponent,
    addProductComponent,
    addBrandComponent
    
    
    ],
  imports: [
    AdministrationRoutingModule,
    CommonModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
    SharedModule,
  
    // TranslateModule 

  ]
})
export class AdministrationModule { }
