import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../service/';
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.less']
})
export class UploadComponent implements OnInit {
  user: String;
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.get('api/user/').subscribe(res => {
       this.user = JSON.stringify(res);
    });
  }

}
