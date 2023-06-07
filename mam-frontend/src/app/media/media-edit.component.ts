import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';

import { MediaService } from './media.service';

@Component({
  selector: 'app-media',
  templateUrl: './media-edit.component.html',
  styleUrls: ['./media-edit.component.css'],
  providers: [ MediaService ]
})
export class MediaEditComponent {

  mediaForm = this.fb.group({
    //name: ['', Validators.required],
    name: [''],
    description: [''],
    type: [''],
    hour: [''],
    minute: [''],
    thumbnailMobile: [''],
    thumbnailTv: [''],
    thumbnailWeb: [''],
    metadata: this.fb.array([
      this.fb.group({
        name: [''],
        value: ['']
      })
    ])
  });

  constructor(private mediaService: MediaService,private fb: FormBuilder) {}

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.mediaForm.value);
  }
  updateMedia(){

  }

  addMetadata(){

  }
}
