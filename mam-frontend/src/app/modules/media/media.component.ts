import { Component,OnInit,OnDestroy } from '@angular/core';
import { Observable , BehaviorSubject} from "rxjs";
import { Router, ActivatedRoute } from "@angular/router";

//import { Media } from "src/app/models/media.model";
import { MediaService } from "./media.service";
import { Subject } from 'rxjs';

import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';


@Component({
  selector: 'app-media',
  templateUrl: './media.component.html',
  styleUrls: ['./media.component.css']
})
export class MediaComponent implements OnInit {
  //mediaList!: any;
  count=0;
  pageSize=10;

  mediaList: any[] = [];
  currentMedia: any = {};
  currentIndex = -1;
  searchValue = '';
  mine = false;
  myTeam = false;

  page = 1;
  pageSizes = [5, 10, 15];
  public isLoaded$: BehaviorSubject<boolean>;
  public userProfile: KeycloakProfile | null = null;

  constructor(private _route: ActivatedRoute,private mediaService: MediaService,
              private readonly keycloak: KeycloakService,) {
  }

  async ngOnInit(){
    this.isLoaded$ = new BehaviorSubject(false);
    this.userProfile = await this.keycloak.loadUserProfile();
    this.retreiveMedia();
    /*
    const params = this.getRequestParams(this.searchValue, this.page, this.pageSize, this.mine, this.myTeam);
    this._route.paramMap.subscribe(params => params);
    var response = this._route.snapshot.data["mediaList"];
    this.mediaList = response.data;
    this.count = response.count;
    this.pageSize = response.pageSize;
    this.page = response.pageNo;
    this.isLoaded$.next(true);*/
  }


  getRequestParams(searchValue: string, page: number, pageSize: number,
                   mine: boolean, myTeam: boolean): any {
    let params: any = {};
    if (searchValue) {
      params['value'] = searchValue;
    }
    if (page) {
      params['page'] = page;
    }
    if (pageSize) {
      params['size'] = pageSize;
    }
    if(mine)
      params['user'] = this.userProfile?.username;
    if(myTeam)
      params['myTeam'] = myTeam;
    return params;
  }

  retreiveMedia(): void {
    this.isLoaded$.next(false);
    const params = this.getRequestParams(this.searchValue, this.page, this.pageSize, this.mine, this.myTeam);
    if(this.searchValue){
      this.mine = false;
      this.mediaService.search(params)
        .subscribe({
          next: (response) => {
            const { data, count } = response;
            this.mediaList = data;
            this.count = count;
            this.isLoaded$.next(true);
          },
          error: (err) => {
            console.log(err);
          }
        });
    }
    else if(this.mine) {
      this.mediaService.findByUser(params)
        .subscribe({
          next: (response) => {
            const { data, count } = response;
            this.mediaList = data;
            this.count = count;
            this.isLoaded$.next(true);
          },
          error: (err) => {
            console.log(err);
          }
        });
    }
    else
      this.mediaService.getAll(params)
        .subscribe({
          next: (response) => {
            const { data, count } = response;
            this.mediaList = data;
            this.count = count;
            this.isLoaded$.next(true);
          },
          error: (err) => {
            console.log(err);
          }
        });
  }

  ngOnDestroy(): void {
    // Do not forget to unsubscribe the event
  }

  refreshList(): void {
   this.retreiveMedia();
   this.currentMedia = {};
   this.currentIndex = -1;
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retreiveMedia();
  }
  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retreiveMedia();
  }

  setActiveMedia(media: Media, index: number): void {
   this.currentMedia = media;
   this.currentIndex = index;
  }

   removeAllMedia(): void {
     this.mediaService.deleteAll()
       .subscribe({
         next: res => {
           console.log(res);
           this.refreshList();
         },
         error: err => {
           console.log(err);
         }
       });

   }

   search(): void {
     this.page = 1;
     this.retreiveMedia();
   }
}
