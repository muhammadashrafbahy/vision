import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  constructor(private _router:Router) { }
  @Input() productList;

  ngOnInit(): void {
 
   console.log(this.productList);
   
   }

   goToSingleProduct(product){
     this._router.navigateByUrl('/home/product/'+product.id)
   }

 
}
