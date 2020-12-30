import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { ProductService } from 'src/app/core/shared/services/product.service';

@Component({
  selector: 'app-adminProducts',
  templateUrl: './adminProducts.component.html',
  styleUrls: ['./adminProducts.component.scss'],
 })
export class adminProductsComponent implements OnInit {
  
  productList;
  constructor(private _router:Router,private modalService:NgbModal,
    private translate: TranslateService, private route: ActivatedRoute,
    private productService:ProductService) {
       
     }
  
 
  ngOnInit(): void {

    this.productService.getAllProduct(0,10).subscribe(product => {
       
    });
    this.productList = [
      {
        id:1,
        img:'iphone1.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00',
        preReductionPrice:'20000'
      },

      {
        id:2,
        img:'iphone2.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs iPhone 11 With FaceTime White 256GB 4G LTE - Egypt SpecsiPhone 11 With FaceTime White 256GB 4G LTE - Egypt SpecsiPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },


      {
        id:3,
        img:'iphone3.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },
      {
        id:4,
        img:'iphone1.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },

      {
        id:4,
        img:'iphone2.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },


      {
        id:4,
        img:'N12265849A_1.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },
    ]
   }

   openAddProduct(){
    this._router.navigate(['./add'],{relativeTo:this.route});

   }
   
  
}
