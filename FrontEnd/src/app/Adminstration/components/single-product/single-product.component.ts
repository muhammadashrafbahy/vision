import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgxGalleryAnimation, NgxGalleryImage, NgxGalleryOptions } from 'ngx-gallery-9';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.scss']
})
export class singleProductComponent implements OnInit {

  constructor(private _router:Router) { }
  salesSlides;
  @Input() productList;
  quntity = 1;
  galleryOptions: NgxGalleryOptions[];
    galleryImages: NgxGalleryImage[];
  ngOnInit(): void {
    this.galleryOptions = [
      {
          width: '600px',
          height: '400px',
          thumbnailsColumns: 4,
          imageAnimation: NgxGalleryAnimation.Slide,
          previewCloseOnClick:true,
          previewCloseOnEsc:true
      },
      // max-width 800
      {
          breakpoint: 800,
          width: '100%',
          height: '600px',
          imagePercent: 80,
          thumbnailsPercent: 20,
          thumbnailsMargin: 20,
          thumbnailMargin: 20
      },
      // max-width 400
      {
          breakpoint: 400,
          preview: false
      }
  ];

  this.galleryImages = [
    {
        small: '../../../../assets/img/banners/en_banner-01.png',
        medium: '../../../../assets/img/banners/en_banner-01.png',
        big: '../../../../assets/img/banners/en_banner-01.png'
    },
    {
      small: '../../../../assets/img/banners/en_banner-01.png',
      medium: '../../../../assets/img/banners/en_banner-01.png',
      big: '../../../../assets/img/banners/en_banner-01.png'
    },
    {
        small: 'assets/3-small.jpg',
        medium: 'assets/3-medium.jpg',
        big: 'assets/3-big.jpg'
    }
];

 
   
   }
   myThumbnail="https://wittlock.github.io/ngx-image-zoom/assets/thumb.jpg";
   myFullresImage="https://wittlock.github.io/ngx-image-zoom/assets/fullres.jpg";
   
   increaseQty(){
     this.quntity++;
   }
   decreaseQty(){
     if (this.quntity > 1) {
       this.quntity --;
     }
   }
}
