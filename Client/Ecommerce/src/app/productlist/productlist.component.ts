import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { products } from '../models/Products';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {
  prdt?:products[]


  allproducts:number=0
  curPage = 1
  itemsPerPage = 3
  maxSize = 5

  constructor(private productser:ProductService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.getallproducts();
  }
  getallproducts()
  {
  this.productser.getAllproducts().subscribe(
        (pr:products |any)=>
        {
        this.prdt = pr;
      },
        (e)=>{console.log(e)}
    );


  }


redirect()
{
  this.router.navigate(['/addproduct']);

}

home()
{
  this.router.navigate(['/adminpage']);

}

numOfPages =  () => {
  return Math.ceil(8 / this.itemsPerPage);
}
}
