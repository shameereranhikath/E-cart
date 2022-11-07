import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient ,  HttpRequest, HttpEvent} from '@angular/common/http';
import { products } from '../models/Products';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  getAllproducts():Observable<products[]>
  {
    return this.http.get<products[]>('http://localhost:8080/listprdt');
   }

}
