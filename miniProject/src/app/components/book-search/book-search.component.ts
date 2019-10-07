import { BookService } from 'src/app/service/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/model/book/book';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent implements OnInit {

  books: Book[];
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookService,
  ) {
  }

  ngOnInit() {
  }
}
