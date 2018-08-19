import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { }

  validateUser(email, password): Observable<User> {
    const user = {
      email: email,
      password: password
    };

    return this.http.post<User>('http://localhost:8080/reimbursements_project/login', user);
  }
}
