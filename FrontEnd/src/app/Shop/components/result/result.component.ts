import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class ResultComponent implements OnInit {
  serachKey = '';
  productList ;
  private routerSubscription = Subscription.EMPTY;

  constructor(private router: Router ,private route: ActivatedRoute) { 

   this.routerSubscription =  this.router.events.subscribe((ev) => {
      if (ev instanceof NavigationEnd) {
    this.serachKey  = this.route.snapshot.queryParams.searchKey;
      }}
      )
  
  }
  ngOnDestroy() {
    this.routerSubscription.unsubscribe();
  }

  ngOnInit(): void {
 
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

 
 

