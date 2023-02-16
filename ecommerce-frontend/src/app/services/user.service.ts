import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Credentials } from '../models/credentials';
import { Item } from '../models/item';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  user:User = {
    email: '',
    firstName: '',
    lastName: '',
    cardNum: 0,
    password: ''
  }

  items: Item[] = [];

  login(credentials:Credentials):Observable<HttpResponse<User>>{
    
    return this.http.post("http://localhost:5000/ecommerce/user/login", credentials, {observe:"response"}) as Observable<HttpResponse<User>>
  
  }

  signUp(user:User):Observable<HttpResponse<User>>{
    
    return this.http.post("http://localhost:5000/ecommerce/user/newuser", user, {observe:"response"}) as Observable<HttpResponse<User>>

  }

  allItems(): Observable<HttpResponse<Item>[]>{

    return this.http.get<Item[]>("http://localhost:5000/ecommerce/item") as unknown as Observable<HttpResponse<Item>[]>
  
  }

  order(id:string): Observable<HttpResponse<any>> {

    return this.http.get("http://localhost:5000/ecommerce/user/order/" + id) as unknown as Observable<HttpResponse<any>>

  }


}
