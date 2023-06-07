import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MediaEditComponent } from './media-edit.component';

describe('MediaComponent', () => {
  let component: MediaEditComponent;
  let fixture: ComponentFixture<MediaEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MediaEditComponent]
    });
    fixture = TestBed.createComponent(MediaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
