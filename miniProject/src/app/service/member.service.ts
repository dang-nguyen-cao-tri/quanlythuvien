import { Member } from './../model/memberModel/member';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  private memberUrl: string;

  constructor(private http: HttpClient) {
    this.memberUrl = 'http://192.168.241.179:8081/member';
  }

  findAll(): Observable<Member[]> {
    return this.http.get<Member[]>(this.memberUrl);
  }

  save(member: Member) {
    if (member.id) {
      return this.http.put(this.memberUrl + '/' + member.id, member);
    } else {
      return this.http.post<Member>(this.memberUrl, member);
    }
  }

  deleteMember(id: string) {
    return this.http.delete(this.memberUrl + '/' + id);
  }

  getMemberById(id: string): Observable<Member> {
    return this.http.get<Member>(this.memberUrl + '/' + id);
  }

}
