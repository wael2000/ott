import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { TranslationService } from './modules/i18n';
// language list
import { locale as enLang } from './modules/i18n/vocabs/en';
import { locale as chLang } from './modules/i18n/vocabs/ch';
import { locale as esLang } from './modules/i18n/vocabs/es';
import { locale as jpLang } from './modules/i18n/vocabs/jp';
import { locale as deLang } from './modules/i18n/vocabs/de';
import { locale as frLang } from './modules/i18n/vocabs/fr';
import { ThemeModeService } from './_metronic/partials/layout/theme-mode-switcher/theme-mode.service';

import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

import {
  Router,
  RouterEvent,
  NavigationStart,
  NavigationEnd
} from "@angular/router";


@Component({
  // tslint:disable-next-line:component-selector
  // eslint-disable-next-line @angular-eslint/component-selector
  selector: 'body[root]',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppComponent implements OnInit {
  isLoaded:boolean = false;
  public isLoggedIn = false;
  public userProfile: KeycloakProfile | null = null;


  constructor(private readonly keycloak: KeycloakService,
    private translationService: TranslationService,
    private modeService: ThemeModeService,
    private _router: Router
  ) {
    // register translations
    this.translationService.loadTranslations(
      enLang,
      chLang,
      esLang,
      jpLang,
      deLang,
      frLang
    );
  }

  public async ngOnInit() {
    this.modeService.init();
    this.routerEvents();
    this.isLoggedIn = await this.keycloak.isLoggedIn();
     if (this.isLoggedIn) {
       this.userProfile = await this.keycloak.loadUserProfile();
     }
  }

  public login() {
    this.keycloak.login();
  }

  public logout() {
    this.keycloak.logout();
  }

  routerEvents() {
    this._router.events.subscribe(event => {
      switch (true) {
        case event instanceof NavigationStart: {
          this.isLoaded = true;
          break;
        }
        case event instanceof NavigationEnd: {
          this.isLoaded = false;
          break;
        }
      }
    });
  }
}
