import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ServiceOrder } from '../../models/service-order.model';
import { ServiceOrderService } from '../../services/service-order.service';

@Component({
  selector: 'app-service-order-list',
  templateUrl: './service-order-list.component.html',
  styleUrls: ['./service-order-list.component.scss'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class ServiceOrderListComponent implements OnInit {

  orders: ServiceOrder[] = [];
  searchCpf = '';
  loading = false;

  constructor(private service: ServiceOrderService, private router: Router) { }

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.loading = true;
    this.service.findAll().subscribe(data => {
      this.orders = data;
      this.loading = false;
    });
  }

  search() {
    if (!this.searchCpf) {
      this.load();
      return;
    }
    this.loading = true;
    this.service.findByCpf(this.searchCpf).subscribe(data => {
      this.orders = data;
      this.loading = false;
    });
  }

  clear() {
    this.searchCpf = '';
    this.load();
  }

  create() {
    this.router.navigate(['/service-orders/new']);
  }

  view(id?: number) {
    if (id) this.router.navigate([`/service-orders/${id}/view`]);
  }

  edit(id?: number) {
    if (id) this.router.navigate([`/service-orders/${id}/edit`]);
  }

  remove(id?: number) {
    if (!id) return;
    if (!confirm('Deseja excluir esta ordem de serviço?')) return;
    this.service.delete(id).subscribe(() => this.load());
  }
}
