import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from 'src/app/core/Auth/login/login.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class cartComponent implements OnInit {
  cartList = [];
  constructor(private _router:Router,private modalService:NgbModal) { }
  
 
  ngOnInit(): void {
    this.cartList.push('s')
   
   }
   goToHome(){
     this._router.navigateByUrl('home')
   }

   checkout(){

      this._router.navigateByUrl('/home/checkout')
     
   }

}
