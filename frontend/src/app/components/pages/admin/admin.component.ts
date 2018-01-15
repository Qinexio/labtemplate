import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../service/';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.less']
})
export class AdminComponent implements OnInit {
  user: String;
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.get('api/user/').subscribe(res => {
       this.user = JSON.stringify(res);
    });
  }

}
