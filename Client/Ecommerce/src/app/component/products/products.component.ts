import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { CartService } from 'src/app/service/cart.service';
import { productimages } from 'src/app/models/productimages';
import { products } from 'src/app/models/Products';



@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  public productList : any ;
  public productList2 : any ;
  public filterCategory : any;
  public filterCategory2 : any
  public filterCategory3 : any
  searchKey:string ="";
  img?:productimages[];
  prdt?:products[];
  constructor(private api : ApiService, private cartService : CartService) { }

  ngOnInit(): void {

    this.getProduct();

  }
  addtocart(item: any){
    this.cartService.addtoCart(item);
  }
  filter(category:string){
    this.filterCategory = this.productList
    .filter((a:any)=>{
      if(a.category == category || category==''){
        return a;
      }
    })
  }

getProduct()
{
  this.api.getProduct()
    .subscribe(res=>{
      this.productList = res;
      this.filterCategory = res;
      this.productList.forEach((a:any) => {


        Object.assign(a,{quantity:1,total:a.priceperunit});

      });

      console.log(this.productList)
    });

    this.cartService.search.subscribe((val:any)=>{
      this.searchKey = val;
    })
}

  getallimages()
  {
  this.api.getAllimages().subscribe(
        (pr:productimages |any)=>
        {
        this.img= pr;
        console.log("Images: "+this.img)
      },
        (e)=>{console.log(e)}
    );
}

getallproducts()
{
this.api.getAllproducts().subscribe(
  (pr:products |any)=>
  {
  this.prdt = pr;
  console.log(this.prdt);
},
  (e)=>{console.log(e)}
  );


}

getcombinedProducts()
{
  this.filterCategory2=this.prdt?.filter((m)=>{
    this.filterCategory=this.img?.filter((k)=>k.prid==m.prid).forEach(item=>{

            this.filterCategory3.push(item.name,m.prnm);
            console.log(item.name,m.prnm)
           }


            );

           });
   console.log("pp"+this.filterCategory3);
}

}
