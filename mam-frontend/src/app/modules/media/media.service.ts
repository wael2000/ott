import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse  } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { map } from "rxjs/operators";
import { catchError } from 'rxjs/operators';
//import { Media } from "src/app/models/media.model";

import {
  Resolve,
  ActivatedRouteSnapshot,
  RouterStateSnapshot
} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class MediaService implements Resolve<any>{

  constructor(private http: HttpClient) {
  }

  getAll(params: any): Observable<any> {
    return this.http.get<any>(environment.backendUrl, { params });
  }

  search(params: any): Observable<any> {
    return this.http.get<any>(`${environment.backendUrl}/search`, { params });
  }

  findByUser(params: any): Observable<any> {
    return this.http.get<any>(`${environment.backendUrl}/user`, { params });
  }

  get(id: any): Observable<any> {
    return this.http.get<any>(`${environment.backendUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(environment.backendUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${environment.backendUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${environment.backendUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(environment.backendUrl);
  }

  findByTitle(title: any): Observable<any[]> {
    return this.http.get<any[]>(`${environment.backendUrl}?title=${title}`);
  }


  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.http.get<any>(environment.backendUrl,route.params);
  }

  /*
  constructor(private http: HttpClient) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.http.get<any>(environment.backendUrl);
  }*/

}
