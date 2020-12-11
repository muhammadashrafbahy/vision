import { CoreRoutingModule } from './core-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { FooterOnlyLayoutComponent } from './layout/footer-only-layout/footer-only-layout.component';
import { FooterComponent } from './layout/footer/footer.component';
import { HeaderComponent } from './layout/header/header.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { NotfoundComponent } from './layout/notfound/notfound.component';
 import { TranslateModule } from '@ngx-translate/core';
import { SharedModule } from './shared/shared.module';
import { LoginComponent } from './Auth/login/login.component';
import { RegisterComponent } from './Auth/register/register.component';



@NgModule({
  declarations: [
    FooterOnlyLayoutComponent,
    FooterComponent,
    HeaderComponent,
    MainLayoutComponent,
    LoginComponent,
    RegisterComponent,
    NotfoundComponent,
  ],
  imports: [
    CommonModule,
    CoreRoutingModule,
    NgbModule,
    FormsModule,
   SharedModule,
   TranslateModule

   
  ],
  providers: [
   ],
})
export class CoreModule { }
