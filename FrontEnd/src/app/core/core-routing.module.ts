import { AuthenticationGuard } from './services/authentication.guard';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { FooterOnlyLayoutComponent } from './layout/footer-only-layout/footer-only-layout.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotfoundComponent } from './layout/notfound/notfound.component';
  
const routes: Routes = [
  // {
  //     path: 'login',
  //     component: FooterOnlyLayoutComponent,
  //     children: [
  //       {
  //         path: '',
  //         //  loadChildren: () => import('../login/login.module').then(mod => mod.LoginModule)

  //       }
  //     ]
  //   },
    {
      path: '',
      component: MainLayoutComponent,
       children: [
         {
           path:'',
           pathMatch:'full',
           redirectTo:'home'
         },
        {
          path: 'home',
          loadChildren: () => import('../Shop/shop.module').then(mod => mod.ShopModule)
        },
        // {
        //   path: 'document-library',
        //   canActivate: [AuthenticationGuard],
        //   loadChildren: () => import('../document-library/document-library.module').then(mod => mod.DocLibModule)
        // },
        // {
        //   path: 'login-page',
        //   canActivate: [AuthenticationGuard],
        //   loadChildren: () => import('../login/login.module').then(mod => mod.LoginModule)
        // },
        // {
        //   path: 'find-workspace',
        //   canActivate: [AuthenticationGuard],
        //   loadChildren: () => import('../workspaces/workspaces.module').then(mod => mod.WorkspacesModule)
        // }
      ]
    },
    {
      path: '**',
      component: NotfoundComponent
    },
  ];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

  export class CoreRoutingModule { }
