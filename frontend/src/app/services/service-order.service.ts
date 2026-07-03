import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceOrder } from '../models/service-order.model';

export interface CustomerCrmSummary {
  customerId: number;
  customerName: string;
  customerPhone: string;
  customerCpf: string;
  totalOrders: number;
  totalSpent: number;
  lastIssueDate?: string;
  category?: string;
}

@Injectable({
  providedIn: 'root'
})
export class ServiceOrderService {

  private apiUrl = '/api/service-orders';
  //private apiUrl = 'https://otica-system-backend.onrender.com/api/service-orders';

  constructor(private http: HttpClient) { }

  findAll(): Observable<ServiceOrder[]> {
    return this.http.get<ServiceOrder[]>(this.apiUrl);
  }

  findById(id: number): Observable<ServiceOrder> {
    return this.http.get<ServiceOrder>(`${this.apiUrl}/${id}`);
  }

  findByCpf(cpf: string): Observable<ServiceOrder[]> {
    return this.http.get<ServiceOrder[]>(`${this.apiUrl}/cpf`, { params: { cpf } });
  }

  findCrmSummaries(): Observable<CustomerCrmSummary[]> {
    return this.http.get<CustomerCrmSummary[]>(`${this.apiUrl}/crm-summaries`);
  }

  findByCustomerId(customerId: number): Observable<ServiceOrder[]> {
    return this.http.get<ServiceOrder[]>(`${this.apiUrl}/customer/${customerId}`);
  }

  create(order: ServiceOrder): Observable<ServiceOrder> {
    return this.http.post<ServiceOrder>(this.apiUrl, order);
  }

  update(id: number, order: ServiceOrder): Observable<ServiceOrder> {
    return this.http.put<ServiceOrder>(`${this.apiUrl}/${id}`, order);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
