import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestInteractionModule } from './test-interaction/test-interaction.module';
import { HttpClientModule } from '@angular/common/http';
import { PermanentHeaderComponent } from './permanent-header/permanent-header.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PermanentHeaderComponent,
    HomeComponent,
    SearchComponent,
  ],
  imports: [
    BrowserModule,
    TestInteractionModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
