import { Observable } from 'rxjs';
import { Book } from '../../model/book/book';
import { BookService } from './../../service/book.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[];
  @Input() book: Book;

  constructor(private bookService: BookService,
              private router: Router,
              private route: ActivatedRoute
              ) { }

  ngOnInit() {
    this.getBooks();

    this.route.paramMap.subscribe(parameterMap => {
      const id = parameterMap.get('id');
      this.getBook(id);
    });
  }

  getBook(id: string): void {
    if (id === null) {
      this.book = {
        id: null,
        createdDate: null,
        bookName: null,
        author: null,
        quantity: null,
        price: null,
        period: null,
        categoryName: null,
        categoryId: null,
        description: null
      };
    } else {
      this.bookService.getBookById(id).subscribe(data => {this.book = data; } );
    }
  }

  getBooks(): void {
    this.bookService.findAll().subscribe(data => {
      this.books = data;
    });
  }

  deleteBook(bookId: string){
    this.bookService.deleteBook(bookId)
      .subscribe((data) => {console.log(data); this.getBooks(); },
       (error) => {console.log(error); }
      );
  }

  detailBook(id: string) {
    this.router.navigate(['/book', id]);
  }

  editBook(id: string) {
    this.router.navigate(['/editbook', id]);
  }

  navigate(url: string) {
    this.router.navigateByUrl(url);
  }

  searchBookByName(n: string): void {
    if (n === '') {
      this.getBooks();
    } else {
      this.bookService.searchBookByName(n).subscribe(data => {this.books = data; this.gotoBookList(); } ) ;
    }
  }

  gotoBookList() {
    this.router.navigate(['/book']);
  }

}
