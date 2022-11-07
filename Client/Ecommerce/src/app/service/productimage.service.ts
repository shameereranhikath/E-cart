import { Injectable } from '@angular/core';
import { productimages } from '../models/productimages';
import { Observable } from 'rxjs';
import { HttpClient ,  HttpRequest, HttpEvent} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductimageService {

  constructor(private http:HttpClient) { }

  getAllimages():Observable<productimages[]>
  {
    return this.http.get<productimages[]>('http://localhost:8080/listimages');
  }
}
