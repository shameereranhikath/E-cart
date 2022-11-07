import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators';
import { products } from '../models/Products';
import { productimages } from '../models/productimages';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http : HttpClient) { }


  getProduct(){
    return this.http.get<any>("http://localhost:8080/listprdtall")
    .pipe(map((res:any)=>{
      return res;
    }))
  }

  getAllproducts()
  {
    return this.http.get<products[]>('http://localhost:8080/listprdt');
  }

   getAllimages()
   {
     return this.http.get<productimages[]>('http://localhost:8080/listimages');
   }
}
