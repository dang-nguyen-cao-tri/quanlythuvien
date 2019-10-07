import { ActivatedRoute, Router } from '@angular/router';
import { Member } from './../../model/memberModel/member';
import { Component, OnInit } from '@angular/core';
import { MemberService } from 'src/app/service/member.service';

@Component({
  selector: 'app-member-form',
  templateUrl: './member-form.component.html',
  styleUrls: ['./member-form.component.css']
})
export class MemberFormComponent implements OnInit {
  member: Member;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private memberService: MemberService, ) {
      this.member = new Member();
    }

    ngOnInit() {
      this.route.paramMap.subscribe(parameterMap => {
        const id = parameterMap.get('id');
        this.getMember(id);
      });
    }

    getMember(id: string): void {
      if (id === null) {
        this.member = {
          id: null,
          createdDate: null,
          name: null,
          gender: null,
          birthDay: null,
          email: null,
        };
      } else {
        this.memberService.getMemberById(id).subscribe(data => {this.member = data; } );
      }
  }

  onSubmit() {
    this.memberService.save(this.member).subscribe(result => this.gotoMemberList());
  }

  gotoMemberList() {
    this.router.navigate(['/member']);
  }

}
