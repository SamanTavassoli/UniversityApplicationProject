import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { CoursePageComponent } from './course-page/course-page.component';
import { UserComponent } from './user/user.component';
import { UserAuthenticationComponent } from './user-authentication/user-authentication.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UniversityPageComponent } from './university-page/university-page.component';
import { AuthGuard } from './user-authentication/auth.guard';
import { UniversityCourseManagerCourseViewComponent } from './university-course-manager-course-view/university-course-manager-course-view.component';
import { UniversityCourseManagerApplicationViewComponent } from './university-course-manager-application-view/university-course-manager-application-view.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'search', component: SearchComponent},
  {path: 'university', component: UniversityPageComponent},
  {path: 'course', component: CoursePageComponent},
  {
    path: 'user', 
    component: UserComponent, 
    children: [
      {path: '', redirectTo: 'authentication', pathMatch: 'full'},
      {path: 'authentication', component: UserAuthenticationComponent, canActivate: [AuthGuard]},
      {path: 'profile', component: UserProfileComponent},
      {path: 'university/course-view', component: UniversityCourseManagerCourseViewComponent},
      {path: 'university/application-view', component: UniversityCourseManagerApplicationViewComponent},
      {path: '**', redirectTo: 'profile', pathMatch: 'full'}
    ]
    },
  {path: '**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
