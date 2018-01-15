import { Component, OnInit } from '@angular/core';
import { ApiService } from './service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})

export class AppComponent implements OnInit {
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.get('api/photo/').subscribe(res => {
       //this.user = JSON.stringify(res);
    });
  }
}
