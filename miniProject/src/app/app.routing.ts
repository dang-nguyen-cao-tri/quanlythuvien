import { Routes } from '@angular/router';

import { BookDetailComponent } from './components/book-detail/book-detail.component';
import { BookFormComponent } from './components/book-form/book-form.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { InfoListComponent } from './components/info-list/info-list.component';
import { MemberFormComponent } from './components/member-form/member-form.component';
import { MemberListComponent } from './components/member-list/member-list.component';

export const routes: Routes = [
  { path: 'book', pathMatch: 'full', component: BookListComponent },
  { path: 'book/:id', pathMatch: 'full', component: BookDetailComponent },
  { path: 'book/name/:name', pathMatch: 'full', component: BookListComponent },
  { path: 'editbook/:id', pathMatch: 'full', component: BookFormComponent },
  { path: 'editmember/:id', pathMatch: 'full', component: MemberFormComponent },
  { path: 'info', pathMatch: 'full', component: InfoListComponent },
  { path: 'member', pathMatch: 'full', component: MemberListComponent },
  { path: 'printreport', pathMatch: 'full', component: BookListComponent },
  { path: '', pathMatch: 'full', redirectTo: '/book' },
  { path: '**', pathMatch: 'full', redirectTo: '/book' }
];
