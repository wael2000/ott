import { MediaComponent } from './media/media.component';
import { MediaEditComponent } from './media/media-edit.component';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from './auth/auth-guard';

const routes: Routes = [
  {
    path: 'media',
    canActivate: [AuthGuard],
    component: MediaComponent ,
    data: { roles: ['mam-user'] }
  },
  {
    path: 'media-edit',
    canActivate: [AuthGuard],
    component: MediaEditComponent ,
    data: { roles: ['mam-user'] }
  },
  {
    path: '',
    component: AppComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
