import { Component, OnInit} from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { Observable , BehaviorSubject} from "rxjs";
import { Router, ActivatedRoute } from "@angular/router";

import { MediaService } from './media.service';


//import { Media } from "src/app/models/media.model";

@Component({
  selector: 'app-media-form',
  templateUrl: './media.edit.component.html',
  styleUrls: ['./media.edit.component.css'],
  providers: [ MediaService ]
})
export class MediaEditComponent implements OnInit{
  model :any;
  id? : number;
  public isLoaded$: BehaviorSubject<boolean>;

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

  constructor(private _route: ActivatedRoute, private mediaService: MediaService,private fb: FormBuilder) {
  }

  async ngOnInit(){
    this.isLoaded$ = new BehaviorSubject(false);
    this.retreiveMedia();
  }

  retreiveMedia(): void {
    this.isLoaded$.next(false);
    this.id = this._route.snapshot.params['id'];
    this.mediaService.get(this.id)
      .subscribe({
        next: (model) => {
          this.model = model;
          this.isLoaded$.next(true);
        },
        error: (err) => {
          console.log(err);
        }
      });
  }


  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.mediaForm.value);
  }
  updateMedia(){

  }

  addMetadata(){

  }
}
