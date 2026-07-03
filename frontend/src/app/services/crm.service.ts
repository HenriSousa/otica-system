import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface CrmDashboardMetrics {
  totalClients: number;
  totalServiceOrders: number;
  totalRevenue: number;
  averageTicket: number;
  vipClients: number;
  newClients: number;
  inactiveClients: number;
  recurringClients: number;
  birthdaysThisMonth: number;
  waitingLaboratoryOrders: number;
  awaitingPickupOrders: number;
}

@Injectable({
  providedIn: 'root'
})
export class CrmService {

  private apiUrl = '/api/crm';

  constructor(private http: HttpClient) { }

  getDashboardMetrics(): Observable<CrmDashboardMetrics> {
    return this.http.get<CrmDashboardMetrics>(`${this.apiUrl}/dashboard`);
  }
}
