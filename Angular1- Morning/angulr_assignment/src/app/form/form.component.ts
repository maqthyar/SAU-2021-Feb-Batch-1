import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

   goalText = '';    // Add this
   btnText = 'Add an Item';
   logs = [];
   len = 0;
   constructor() { }
   ngOnInit(): void {
  }

  helper() {

    for (let i = this.len; i < this.goalText.length; i++) {
      console.log(this.goalText[i]);

      this.logs.push({
      value : this.goalText[i],
      time : new Date()
    });
    }
    this.len = this.goalText.length;

  }

}
