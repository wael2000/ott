import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse  } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MediaService {
  //media!: Media;
  monolithUrl =  'http://127.0.0.1:8082/ott/media'

  constructor(private http: HttpClient) {
  }

  getMedia() : Observable<Media[]> {
    //return this.http.get<Media[]>(this.monolithUrl).pipe();
    return this.http.get<any>(this.monolithUrl).pipe();
  }

}
