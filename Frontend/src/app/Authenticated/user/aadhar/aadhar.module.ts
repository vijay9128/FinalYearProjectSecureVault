import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { AadharRoutingModule } from './aadhar-routing.module';
import { AddAadharComponent } from './add-aadhar/add-aadhar.component';
import { ViewAadharComponent } from './view-aadhar/view-aadhar.component';
import { AadharComponent } from './aadhar/aadhar.component';

console.warn("Aadhar loaded!")
@NgModule({
  declarations: [
    AddAadharComponent,
    ViewAadharComponent,
    AadharComponent
  ],
  imports: [
    CommonModule,
    AadharRoutingModule,
    ReactiveFormsModule
  ]
})
export class AadharModule { }
