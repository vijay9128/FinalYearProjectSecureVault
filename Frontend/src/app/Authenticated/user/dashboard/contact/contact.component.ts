import { Component } from '@angular/core';
import { Location } from '@angular/common';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  constructor(private location:Location){}
  back(){
this.location.back();
  }


  submit(){
    
  }
}
