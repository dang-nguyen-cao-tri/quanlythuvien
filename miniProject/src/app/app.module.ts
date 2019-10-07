import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { routes } from './app.routing';
import { BookDetailComponent } from './components/book-detail/book-detail.component';
import { BookFormComponent } from './components/book-form/book-form.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { BookSearchComponent } from './components/book-search/book-search.component';
import { InfoListComponent } from './components/info-list/info-list.component';
import { MemberFormComponent } from './components/member-form/member-form.component';
import { MemberListComponent } from './components/member-list/member-list.component';
import { BookService } from './service/book.service';
import { CategoryService } from './service/category.service';
import { MemberService } from './service/member.service';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookFormComponent,
    MemberListComponent,
    BookDetailComponent,
    MemberFormComponent,
    BookSearchComponent,
    InfoListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [BookService, MemberService, CategoryService],
  bootstrap: [AppComponent]
})
export class AppModule {}
