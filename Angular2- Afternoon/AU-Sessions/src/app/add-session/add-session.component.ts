import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Session} from "../modal/session";
import { MatDialogRef } from '@angular/material/dialog';
import {SessionService} from "../session.service";
import {SessionListComponent} from "../session-list/session-list.component";


@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {

 todoForm: FormGroup;
  constructor(private sessionService: SessionService, private dialogRef: MatDialogRef<SessionListComponent>) { }


  ngOnInit(): void {
    this.todoForm = new FormGroup({
      title : new FormControl('', Validators.required),
      instructor : new FormControl('', Validators.required),
      desc : new FormControl('')
    });
  }
  get title(): FormControl {
    return this.todoForm.get('title') as FormControl;
  }

  get desc(): FormControl {
    return this.todoForm.get('desc') as FormControl;
  }

  get instructor(): FormControl {
    return this.todoForm.get('instructor') as FormControl;
  }

  addToList(): void {
    const session: Session = {
      name : this.title.value,
      instructor : this.instructor.value,
      desc : this.desc.value
    };
    this.sessionService.addSession(session);
    this.dialogRef.close();
  }


}
