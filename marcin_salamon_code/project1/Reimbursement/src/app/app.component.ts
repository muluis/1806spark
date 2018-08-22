import { Component } from '@angular/core';

import { LoggedUserService } from './services/logged-user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Reimbursement';

  constructor(private logged: LoggedUserService) { }
}
