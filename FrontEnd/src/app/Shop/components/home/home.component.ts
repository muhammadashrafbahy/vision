import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

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

}
