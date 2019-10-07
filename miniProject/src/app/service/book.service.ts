import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Book } from '../model/book/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private bookUrl: string;

  constructor(private http: HttpClient) {
    this.bookUrl = 'http://192.168.241.179:8081/book';
  }

  findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.bookUrl);
  }

  save(book: Book) {
    if (book.id) {
      return this.http.put(this.bookUrl + '/' + book.id, book);
    } else {
      return this.http.post<Book>(this.bookUrl, book);
    }
  }

  deleteBook(bookId: string) {
    return this.http.delete(this.bookUrl + '/' + bookId);
  }

  getBookById(bookId: string): Observable<Book> {
    return this.http.get<Book>(this.bookUrl + '/' + bookId);
  }

  searchBookByName(n: string): Observable<Book[]> {
    return this.http.get<Book[]>(this.bookUrl + '/name/' + n);
  }

}
