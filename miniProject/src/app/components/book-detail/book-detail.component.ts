import { Component, OnInit } from "@angular/core";
import { Route, ActivatedRoute } from "@angular/router";
import { BookService } from "src/app/service/book.service";
import { Book } from "src/app/model/book/book";

@Component({
  selector: "app-book-detail",
  templateUrl: "./book-detail.component.html",
  styleUrls: ["./book-detail.component.css"]
})
export class BookDetailComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private bookService: BookService
  ) {}
  book: Book;

  imageUrl = "./assets/img/hinh";
  imageType = ".jpg";

  ngOnInit() {
    this.route.paramMap.subscribe(parameterMap => {
      let id = parameterMap.get("id");
      this.getBook(id);

      this.imageUrl += id + this.imageType;
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
      this.bookService.getBookById(id).subscribe(data => {
        this.book = data;
      });
    }
  }
}
