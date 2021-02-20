/* tslint:disable:no-string-literal */
import {Component, Inject, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {SessionListComponent} from "../session-list/session-list.component";
import {Session} from "../modal/session";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-modify-session',
  templateUrl: './modify-session.component.html',
  styleUrls: ['./modify-session.component.css']
})
export class ModifySessionComponent implements OnInit {

  modifyForm: FormGroup;

  constructor(@Inject(MAT_DIALOG_DATA) private data: Session , private dialogRef: MatDialogRef<SessionListComponent>,
              private sessionService: SessionService) { }
  get title(): FormControl {
    return this.modifyForm.get('title') as FormControl;
  }

  get desc(): FormControl {
    return this.modifyForm.get('desc') as FormControl;
  }

  get instructor(): FormControl {
    return this.modifyForm.get('instructor') as FormControl;
  }


  ngOnInit(): void
  {
    this.modifyForm = new FormGroup(
      {
      title : new FormControl(this.data['person'].name, Validators.required),
      instructor : new FormControl(this.data['person'].instructor, Validators.required),
      desc : new FormControl(this.data['person'].desc)
      }
    );
  }

  modifyList(): void
  {
      const session: Session = {
      name : this.title.value,
      instructor : this.instructor.value,
      desc : this.desc.value
    };
      this.sessionService.modifySession(session);
      this.dialogRef.close();
  }

}
