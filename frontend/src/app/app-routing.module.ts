import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components';
import { AboutComponent } from './components';
import { UploadComponent } from './components';
import { AdminComponent } from './components';
import { ImageComponent } from './components';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'about', component: AboutComponent
  },
  {
    path: 'upload', component: UploadComponent
  },
  {
    path: 'admin', component: AdminComponent
  },
    {
    path: 'image', component: ImageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
