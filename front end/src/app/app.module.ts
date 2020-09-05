import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestInteractionModule } from './test-interaction/test-interaction.module';
import { HttpClientModule } from '@angular/common/http';
import { PermanentHeaderComponent } from './permanent-header/permanent-header.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent} from './search/search.component';
import { FormsModule } from '@angular/forms';
import { CoursePageComponent } from './course-page/course-page.component';
import { UserComponent } from './user/user.component';
import { UserAuthenticationComponent } from './user-authentication/user-authentication.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UniversityPageComponent } from './university-page/university-page.component';
import { AuthGuard } from './user-authentication/auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    PermanentHeaderComponent,
    HomeComponent,
    SearchComponent,
    CoursePageComponent,
    UserComponent,
    UserAuthenticationComponent,
    UserProfileComponent,
    UniversityPageComponent
  ],
  imports: [
    BrowserModule,
    TestInteractionModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
