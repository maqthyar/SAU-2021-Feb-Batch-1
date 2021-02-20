import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatButtonModule} from '@angular/material/button';

import {MatCardModule} from '@angular/material/card';


import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing/app-routing.module';

import {MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import {SessionListComponent} from "./session-list/session-list.component";
import { AddSessionComponent } from './add-session/add-session.component';
import {RouterModule} from "@angular/router";
import { ModifySessionComponent } from './modify-session/modify-session.component';

@NgModule({
  declarations: [
    AppComponent,
    SessionListComponent,
    AddSessionComponent,
    ModifySessionComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatDialogModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: MatDialogRef,
      useValue: {}
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
