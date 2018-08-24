import { CurrentUserService } from './../current-user.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  posId;
  user: Users;

  constructor(private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    this.posId = this.user.pos_id;
    // this.setUpNavbar(this.user);
  }

  // setUpNavbar(user) {
  //   const home = document.getElementsByClassName('home');
  //   if (user.pos_id === 1) {
  //     this.posId =
  //   }
  // }

  logout() {
    this.currentUser.setCurrentUser(null);
    this.router.navigate(['login']);
  }

}
