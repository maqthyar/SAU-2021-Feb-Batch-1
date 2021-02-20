/* tslint:disable */
import { Component, OnInit } from '@angular/core';
import {Session} from '../modal/session';
import {SessionService} from "../session.service";
import {MatDialog} from "@angular/material/dialog";
import {AddSessionComponent} from "../add-session/add-session.component";
import {ModifySessionComponent} from "../modify-session/modify-session.component";

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.css']
})
export class SessionListComponent implements OnInit {

  constructor(private sessionService: SessionService, private dialog: MatDialog) { }

  selectedItem = '';

  sessionItems: Session[] = [];
  ngOnInit(): void
  {
    this.sessionItems = this.sessionService.getSession();
  }
  setItem(item)
  {
    this.selectedItem = item;
  }

  deleteSessionItem(item)
  {
    this.sessionService.removeSession(item);
    this.sessionItems = this.sessionService.getSession();
  }

  addSessionItem()
  {
    this.dialog.open(AddSessionComponent,{
      width: '300px'
    });
  }

  modifySessionItem(item)
  {
    const dia = this.dialog.open(ModifySessionComponent,{
      width: '300px',
      data: {
        person: {
          name: item.name,
          desc: item.desc,
          instructor: item.instructor
        }
      }
    })

    dia.afterClosed().subscribe(() => {
      this.sessionItems = this.sessionService.getSession()
    })


  }

}
