import { MemberService } from './../../service/member.service';
import { Member } from './../../model/memberModel/member';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent implements OnInit {
  members: Member[];

  constructor(private memberService: MemberService,
              private router: Router, ) { }

  ngOnInit() {
    this.memberService.findAll().subscribe(data => {
      this.members = data;
    });
  }

  deleteMember(id: string) {
    this.memberService.deleteMember(id)
      .subscribe((data) => {console.log(data); this.getMembers(); },
       (error) => {console.log(error); }
      );
  }

  getMembers(): void {
    this.memberService.findAll().subscribe(data => {
      this.members = data;
    });
  }

  editMember(id: string) {
    this.router.navigate(['/editmember', id]);
  }
}
