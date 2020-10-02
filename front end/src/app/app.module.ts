import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { UniversityCourseManagerComponent } from './university-course-manager/university-course-manager.component';
import { StudentApplicationManagerComponent } from './student-application-manager/student-application-manager.component';
import { UniversityCourseManagerCourseViewComponent } from './university-course-manager-course-view/university-course-manager-course-view.component';
import { UniversityCourseManagerApplicationViewComponent } from './university-course-manager-application-view/university-course-manager-application-view.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {MatButtonToggleModule} from '@angular/material/button-toggle';

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
    UniversityPageComponent,
    UniversityCourseManagerComponent,
    StudentApplicationManagerComponent,
    UniversityCourseManagerCourseViewComponent,
    UniversityCourseManagerApplicationViewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    Ng2SearchPipeModule,
    BrowserAnimationsModule,
    
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatListModule,
    MatButtonToggleModule
  ],
  providers: [AuthGuard, authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
