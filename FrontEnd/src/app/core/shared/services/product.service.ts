import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  SERVER_URL:string = environment.SERVER_URL;
  constructor(
    
              private router: Router,
              private toastr: ToastrService,
              // private securityService: NgxSecurityService
              private httpClient:HttpClient
              ) {
                
          
  }

  getAllProduct(pageIndex , pageSize ) {

    return this.httpClient.get(this.SERVER_URL + '/product/'+pageIndex + '/' +pageSize);
  }

  getAllBrands(){
    return this.httpClient.get(this.SERVER_URL + 'brand');

  }

addBrand(brand){
    const HttpUploadOptions = {
        headers: new HttpHeaders({ "Content-Type": "multipart/form-data"})
      }
    return this.httpClient.post(this.SERVER_URL + 'brand',brand);   
}
addProduct(product){
    return this.httpClient.post(this.SERVER_URL + 'product',product);   

}

}
