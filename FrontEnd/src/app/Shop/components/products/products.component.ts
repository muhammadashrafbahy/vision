import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  constructor() { }
  salesSlides;
  productList;

  ngOnInit(): void {
    this.salesSlides =[
      {
        img:'en_banner-01.png',
        title:'Hurry Up to get Our Offer',
        desc:'Hurry Up to get Our Offer',
        discount:'10',
        
      },

      {
        img:'en_banner-01.png',
        title:'Hurry Up to get Our Offer',
        desc:'Hurry Up to get Our Offer',
        discount:'50'
      },

    ]

    this.productList = [
      {
        img:'iphone1.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00',
        preReductionPrice:'20000'
      },

      {
        img:'iphone2.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs iPhone 11 With FaceTime White 256GB 4G LTE - Egypt SpecsiPhone 11 With FaceTime White 256GB 4G LTE - Egypt SpecsiPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },


      {
        img:'iphone3.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },
      {
        img:'iphone1.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },

      {
        img:'iphone2.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },


      {
        img:'N12265849A_1.jpg',
        desc:'iPhone 11 With FaceTime White 256GB 4G LTE - Egypt Specs',
        currency:'ج.م',
        price:'19599.00'
      },
    ]
   }

}
