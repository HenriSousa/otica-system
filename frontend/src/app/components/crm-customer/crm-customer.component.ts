import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Customer } from '../../models/customer.model';
import { ServiceOrder } from '../../models/service-order.model';
import { CustomerService } from '../../services/customer.service';
import { ServiceOrderService } from '../../services/service-order.service';

@Component({
  selector: 'app-crm-customer',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './crm-customer.component.html',
  styleUrls: ['./crm-customer.component.scss']
})
export class CrmCustomerComponent implements OnInit {
  customer: Customer | null = null;
  orders: ServiceOrder[] = [];
  loading = false;
  error = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService,
    private serviceOrderService: ServiceOrderService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!id) {
      this.error = 'Cliente inválido.';
      return;
    }

    this.loadCustomer(id);
  }

  loadCustomer(id: number): void {
    this.loading = true;
    this.error = '';

    this.customerService.findById(id).subscribe({
      next: (customer) => {
        this.customer = customer;
        this.serviceOrderService.findByCustomerId(customer.id!).subscribe({
          next: (orders) => {
            this.orders = orders;
            this.loading = false;
          },
          error: () => {
            this.error = 'Erro ao carregar histórico de ordens de serviço.';
            this.loading = false;
          }
        });
      },
      error: () => {
        this.error = 'Erro ao carregar cliente.';
        this.loading = false;
      }
    });
  }

  openWhatsApp(): void {
    if (!this.customer?.phone) return;

    const normalizedPhone = this.customer.phone.replace(/\D/g, '');
    const message = encodeURIComponent(`Olá ${this.customer.name}!

Obrigado por escolher a DK VISION.

Como podemos ajudá-lo hoje?`);
    const url = `https://wa.me/${normalizedPhone}?text=${message}`;
    window.open(url, '_blank', 'noopener,noreferrer');
  }

  viewOrder(orderId?: number): void {
    if (orderId) {
      this.router.navigate([`/service-orders/${orderId}/view`]);
    }
  }

  downloadClientPdf(orderId?: number): void {
    if (orderId) {
      this.router.navigate([`/service-orders/${orderId}/view`], { queryParams: { pdf: 'client' } });
    }
  }

  downloadLaboratoryPdf(orderId?: number): void {
    if (orderId) {
      this.router.navigate([`/service-orders/${orderId}/view`], { queryParams: { pdf: 'laboratory' } });
    }
  }

  formatCurrency(value: number | undefined): string {
    return new Intl.NumberFormat('pt-BR', {
      style: 'currency',
      currency: 'BRL'
    }).format(value || 0);
  }

  get totalOrders(): number {
    return this.orders.length;
  }

  get totalSpent(): number {
    return this.orders.reduce((sum, order) => sum + (order.totalValue || 0), 0);
  }

  get averageTicket(): number {
    if (!this.totalOrders) return 0;
    return this.totalSpent / this.totalOrders;
  }

  get lastPurchase(): string {
    if (!this.orders.length) return 'Sem compras';
    const lastOrder = [...this.orders].sort((a, b) => this.getOrderDateValue(b) - this.getOrderDateValue(a))[0];
    return lastOrder?.issueDate || 'Sem data';
  }

  get clientSince(): string {
    if (!this.customer?.id) return '—';
    const firstOrder = [...this.orders].sort((a, b) => this.getOrderDateValue(a) - this.getOrderDateValue(b))[0];
    return firstOrder?.issueDate || '—';
  }

  private getOrderDateValue(order: ServiceOrder): number {
    const rawDate = order.issueDate || order.deliveryDate || '';
    const date = new Date(rawDate);
    return Number.isNaN(date.getTime()) ? 0 : date.getTime();
  }
}
