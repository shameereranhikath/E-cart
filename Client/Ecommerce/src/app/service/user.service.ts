import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient ,  HttpRequest, HttpEvent} from '@angular/common/http';
import { Users } from '../models/Users';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }


   //calling a java restapi to search a single record
   getbyemail(em: any): Observable<Users> {
    const urlfind="http://localhost:8080/find";
    return this.http.get(`${urlfind}/${em}`);
  }

}
