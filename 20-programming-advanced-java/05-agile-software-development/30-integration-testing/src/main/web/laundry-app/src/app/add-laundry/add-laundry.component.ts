import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {LaundryService} from "../laundry.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-laundry',
  templateUrl: './add-laundry.component.html',
  styleUrls: ['./add-laundry.component.css']
})
export class AddLaundryComponent implements OnInit {
  laundryForm = this.fb.group({
    'description':'',
    'type':'',
    'owner':'',
  });

  constructor(private fb: FormBuilder, private laundryService: LaundryService, private router: Router) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.laundryService.createLaundry(this.laundryForm.value).subscribe(() =>
      this.router.navigateByUrl("/laundry-list")
    );
  }
}
