import { Observable } from 'rxjs';
import { Book } from 'src/app/model/book/book';
import { BookService } from 'src/app/service/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Library System';
  books: Book[];
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookService,
  ) {
  }
  ngOnInit(): void {

  }

}
