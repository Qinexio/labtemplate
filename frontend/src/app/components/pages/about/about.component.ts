import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../service/';
@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.less']
})
export class AboutComponent implements OnInit {
  user: String;
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.get('api/user/').subscribe(res => {
       this.user = JSON.stringify(res);
    });
  }

}
