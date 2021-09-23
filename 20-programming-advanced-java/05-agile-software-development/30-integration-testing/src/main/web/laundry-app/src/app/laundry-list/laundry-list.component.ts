import {Component, OnInit} from '@angular/core';
import {LaundryService} from "../laundry.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-laundry-list',
  templateUrl: './laundry-list.component.html',
  styleUrls: ['./laundry-list.component.css']
})
export class LaundryListComponent implements OnInit {

  laundryList: Observable<any>;

  constructor(private laundryService: LaundryService) {
    this.laundryList = this.laundryService.getLaundryList();
  }

  ngOnInit(): void {
  }

}
