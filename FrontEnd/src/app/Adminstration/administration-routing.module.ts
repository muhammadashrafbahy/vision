import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { addProductComponent } from './components/add-product/add-product.component';
import { adminProductsComponent } from './pages/adminProducts/adminProducts.component';
import { HomeAdminComponent } from './pages/home/homeAdmin.component';
import { usersComponent } from './pages/users/users.component';

 

const routes: Routes = [
  {
    path: '',
    component: HomeAdminComponent,
},
{
  path:'users',
  // canActivate:[],
  component:usersComponent
},
{
  path:'products',
  component:adminProductsComponent,
 
},
{
  path:'products/add',
  component:addProductComponent
}


 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule { }
