# Hadif

1 - user info
src/app/_metronic/partials/layout/extras/dropdown-inner/unser-inner

2 - authentication

src/app/app-modules.ts

src/app/auth/auth-gaurd.ts

3 - Layout
src/app/_metronic/layout/layout.module

4 - if you want to disable modules, remove them from layout.module.ts

4 - custom modules

4-1 add to src/app/modules

4-2 add module routing to

src/app/pages/routing.ts

5 - Media module 
- app/modules/media
- media.component.css		
- media.component.ts		
- media.edit.component.spec.ts	
- media.service.spec.ts
- media.component.html		
- media.edit.component.css	
- media.edit.component.ts		
- media.service.ts
- media.component.spec.ts		
- media.edit.component.html	
- media.module.ts


module routes need to be added under 

app/pages/rounting.ts
```sh
{
  path: 'media',
  resolve: {
    mediaList: MediaService
  },
  loadChildren: () =>
    import('../modules/media/media.module').then((m) => m.MediaModule),
}
```


## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
