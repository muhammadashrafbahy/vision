import { CoreRoutingModule } from './core-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterOnlyLayoutComponent } from './layout/footer-only-layout/footer-only-layout.component';
import { FooterComponent } from './layout/footer/footer.component';
import { HeaderComponent } from './layout/header/header.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { NotfoundComponent } from './layout/notfound/notfound.component';


@NgModule({
  declarations: [
    FooterOnlyLayoutComponent,
    FooterComponent,
    HeaderComponent,
    MainLayoutComponent,
    NotfoundComponent,
  ],
  imports: [
    CommonModule,
    CoreRoutingModule,
    NgbModule,
    FormsModule,
   
  ],
  providers: [
  ],
})
export class CoreModule { }
