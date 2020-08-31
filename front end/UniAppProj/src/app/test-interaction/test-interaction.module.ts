import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TestInteractionComponent } from './test-interaction.component';


@NgModule({
  declarations: [TestInteractionComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    TestInteractionComponent
  ]
})
export class TestInteractionModule { }
