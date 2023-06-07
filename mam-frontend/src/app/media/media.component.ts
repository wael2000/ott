import { Component } from '@angular/core';
import { MediaService } from './media.service';

@Component({
  selector: 'app-media',
  templateUrl: './media.component.html',
  styleUrls: ['./media.component.css'],
  providers: [ MediaService ]
})
export class MediaComponent {
  mediaList!: any;


  constructor(private mediaService: MediaService) {
    this.mediaService.getMedia()
      .subscribe(mediaList => this.mediaList = mediaList)
  }

  public getMedia() {
    this.mediaService.getMedia()
      .subscribe(mediaList => this.mediaList = mediaList)
  }
}
