import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Info } from '../model/info/info';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class InfoService {
  private infoUrl: string;

  constructor(private http: HttpClient) {
    this.infoUrl = 'http://192.168.241.179:8081/info';
  }

  findAll(): Observable<Info[]> {
    return this.http.get<Info[]>(this.infoUrl);
  }

}
