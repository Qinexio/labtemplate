import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../service/';
@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.less']
})
export class ImageComponent implements OnInit {
  user: String;
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.get('api/user/').subscribe(res => {
       this.user = JSON.stringify(res);
    });
  }

}
