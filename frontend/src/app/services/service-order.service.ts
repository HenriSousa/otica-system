import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServiceOrder } from '../models/service-order.model';

@Injectable({
  providedIn: 'root'
})
export class ServiceOrderService {

  private apiUrl = '/api/service-orders';

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
