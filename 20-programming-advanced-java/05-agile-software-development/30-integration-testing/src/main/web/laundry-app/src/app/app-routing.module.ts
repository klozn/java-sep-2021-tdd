import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LaundryListComponent} from "./laundry-list/laundry-list.component";
import {AddLaundryComponent} from "./add-laundry/add-laundry.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path: 'laundry-list', component: LaundryListComponent},
  {path: 'add-laundry', component: AddLaundryComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
