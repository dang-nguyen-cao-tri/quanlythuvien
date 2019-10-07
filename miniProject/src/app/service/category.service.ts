import { Category } from './../model/categoryModel/category';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private categoryUrl: string;

  constructor(private http: HttpClient) {
    this.categoryUrl = 'http://192.168.241.179:8081/category';
  }

  findAll(): Observable<Category[]> {
    return this.http.get<Category[]>(this.categoryUrl);
  }
}
