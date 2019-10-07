import { CategoryService } from './../../service/category.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../../model/book/book';
import { BookService } from './../../service/book.service';
import { Category } from 'src/app/model/categoryModel/category';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
  book: Book;
  categoryList: Category[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookService,
    private categoryService: CategoryService
  ) {
    this.book = new Book();
  }

  ngOnInit() {
    this.categoryService.findAll().subscribe(data => {
      this.categoryList = data;
    });

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

  onSubmit() {
    const category = this.categoryList.find(value => {
      return value.typeName === this.book.categoryName;
    });

    this.book.categoryId = category.id;

    this.bookService.save(this.book).subscribe(result => this.gotoBookList());
  }

  gotoBookList() {
    this.router.navigate(['/book']);
  }

}
