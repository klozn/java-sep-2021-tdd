import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LaundryService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private httpClient: HttpClient) {
  }

  getLaundryList(): Observable<any> {
    return this.httpClient.get("/laundries", this.httpOptions)
  }

  createLaundry(value: any) {
    return this.httpClient.post("/laundries", value, this.httpOptions)
  }
}
