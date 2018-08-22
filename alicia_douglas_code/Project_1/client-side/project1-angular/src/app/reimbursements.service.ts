import { CurrentUserService } from './current-user.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reimbursements } from './models/reimbursements.model';


@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  reimbursements: Observable<Reimbursements[]>;

  constructor(private httpClient: HttpClient, private currentUser: CurrentUserService) { }

  getAllReimbursements(): void {
    this.reimbursements = this.httpClient.get<Reimbursements[]>('http://localhost:8080/reimbursement/reimbursement');
  }

  getReimbursementsArray(): Observable<Reimbursements[]> {
    return this.reimbursements;
  }

  getReimbursementById(id) {
    return this.httpClient.get<Reimbursements[]>('http://localhost:8080/reimbursement/reimbursement/id' + '?userId=' + id);
  }

  getPendingReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://localhost:8080/reimbursement/pending/id?userId=${id}`);
  }

  getResolvedReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://localhost:8080/reimbursement/resolved/id?userId=${id}`);
  }

  createNewReimbursement(amt, desc, type, img) {
    const reimb = {
      u_id: this.currentUser.getCurrentUser().u_id,
      amt: amt,
      desc: desc,
      type: type,
      img: img
    };

    console.log(reimb);

    this.httpClient.post<Reimbursements>('http://localhost:8080/reimbursement/reimbursement', reimb);

    // console.log('after post statement');
  }
}
