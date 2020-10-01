import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-university-page',
  templateUrl: './university-page.component.html',
  styleUrls: ['./university-page.component.css']
})
export class UniversityPageComponent implements OnInit {

  universityPublicInfo;
  
  constructor(
    private route: ActivatedRoute,
    private _location: Location,
    private userService: UserService
    ) { 

  }

  ngOnInit(): void {
    this.route.queryParams
    .subscribe( params => {
      this.userService.getUniversityPublicInfo(params.universityId).subscribe( publicInfo => {
        this.universityPublicInfo = publicInfo;
      })
    })
  }

  back() {
    this._location.back();
  }

}
