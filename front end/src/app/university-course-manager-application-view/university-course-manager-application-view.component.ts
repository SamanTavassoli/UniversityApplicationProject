import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Application } from '../_models/application';
import { ApplicationStatus } from '../_models/application-status';
import { ApplicationService } from '../_services/application.service';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-university-course-manager-application-view',
  templateUrl: './university-course-manager-application-view.component.html',
  styleUrls: ['./university-course-manager-application-view.component.css']
})
export class UniversityCourseManagerApplicationViewComponent implements OnInit {

  ApplicationStatus = ApplicationStatus;

  application: Application;
  username: string;

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private applicationService: ApplicationService,
    private userService: UserService
    ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.applicationService.getApplication(params.applicationId).subscribe(application => {
        this.application = application;
        

        this.userService.getStudentUsername(this.application.userId).subscribe(response => {
          this.username = response.username
        })
      })
    })
  }

  back() {
    this.location.back();
  }

  setInReview() {
    this.applicationService.setApplicationToInReview(this.application.applicationId).subscribe(success => {
      if (success) {
        this.ngOnInit()
      } else {
        window.alert('This shouldn\' fail')
      }
    })
  }

  setAccepted() {
    this.setDecisionMade(true);
  }

  setDeclined() {
    this.setDecisionMade(false);
  }

  setDecisionMade(accepted: boolean) {
    this.applicationService.setApplicationDecisionMade(this.application.applicationId, accepted).subscribe(success => {
      if (success) {
        this.ngOnInit()
      } else {
        window.alert('This shouldn\' fail')
      }
    })
  }

  reset() {
    this.applicationService.resetApplication(this.application.applicationId).subscribe( response => {
      this.ngOnInit();
    }
    );
  }
}
