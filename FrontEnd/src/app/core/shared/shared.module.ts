
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { ProductsComponent } from './components/products/products.component';
import { NgWizardConfig, NgWizardModule, THEME } from 'ng-wizard';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { NgxSpinnerModule } from 'ngx-spinner';
const ngWizardConfig: NgWizardConfig = {
  theme: THEME.default
  };
 
 
@NgModule({
  declarations: [ConfirmDialogComponent , ProductsComponent ],
  imports: [
    CommonModule,
    ToastrModule.forRoot(),
    NgbModule,    
    HttpClientModule,
    TranslateModule.forRoot({
      defaultLanguage: 'en',
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
    NgWizardModule.forRoot(ngWizardConfig),
    NgxSpinnerModule,

  ],
  exports: [
  TranslateModule,
    NgWizardModule,
    NgxSpinnerModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule,
    ConfirmDialogComponent,
    ProductsComponent,
    ],
  entryComponents: [ ConfirmDialogComponent]
})

export class SharedModule { }
export function localeFactory(): string {
  return (window.clientInformation && window.clientInformation.language) || window.navigator.language;
}
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, 'assets/i18n/', '.json');
}