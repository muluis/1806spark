import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  username = 'bobbert'
  count = 0;

  updateUsername= function() {
    console.log('');
  }


  updateCount = function() {
    this.count++;
  }

  constructor() { }

  ngOnInit() {
  }

}