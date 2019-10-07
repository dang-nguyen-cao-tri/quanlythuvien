import { Component, OnInit } from '@angular/core';
import { Info } from 'src/app/model/info/info';
import { InfoService } from 'src/app/service/info.service';

@Component({
  selector: 'app-info-list',
  templateUrl: './info-list.component.html',
  styleUrls: ['./info-list.component.css']
})

export class InfoListComponent implements OnInit {

  infos: Info[];

  constructor(private infoService: InfoService,
              ) { }

  ngOnInit() {
    this.getBooks();
  }

  getBooks(): void {
    this.infoService.findAll().subscribe(data => {
      this.infos = data;
    });
  }
}
