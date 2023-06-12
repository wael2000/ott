import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from "../../_metronic/shared/shared.module";
import { RouterModule } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule } from '@angular/forms';

import { MediaComponent } from "./media.component";
import { MediaEditComponent } from "./media.edit.component";


@NgModule({
  declarations: [
    MediaComponent,
    MediaEditComponent
  ],
  imports: [
    CommonModule,FormsModule,
    NgxPaginationModule,
    SharedModule,
    RouterModule.forChild([
      {
        path: '',
        component: MediaComponent
      },
      {
        path: 'edit/:id',
        component: MediaEditComponent
      },
    ]),
  ]
})
export class MediaModule { }
