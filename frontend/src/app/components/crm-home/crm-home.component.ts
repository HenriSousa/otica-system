import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { Customer } from '../../models/customer.model';
import { CustomerCrmSummary } from '../../services/service-order.service';
import { ServiceOrder } from '../../models/service-order.model';
import { ServiceOrderService } from '../../services/service-order.service';

interface CustomerCrmSummaryView {
  customer: Customer;
  totalOrders: number;
  totalSpent: number;
  lastOrderLabel: string;
}

@Component({
  selector: 'app-crm-home',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './crm-home.component.html',
  styleUrls: ['./crm-home.component.scss']
})
export class CrmHomeComponent implements OnInit {
  customers: CustomerCrmSummaryView[] = [];
  loading = false;
  error = '';
  nameFilter = '';
  cpfFilter = '';
  phoneFilter = '';

  private allCustomers: CustomerCrmSummaryView[] = [];

  constructor(
    private serviceOrderService: ServiceOrderService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.loading = true;
    this.error = '';

    this.serviceOrderService.findCrmSummaries().subscribe({
      next: (summaries) => {
        this.allCustomers = summaries.map((summary) => ({
          customer: {
            id: summary.customerId,
            name: summary.customerName,
            phone: summary.customerPhone,
            cpf: summary.customerCpf,
            address: '',
            neighborhood: '',
            referencePoint: ''
          },
          totalOrders: summary.totalOrders,
          totalSpent: summary.totalSpent,
          lastOrderLabel: summary.lastIssueDate
            ? `Última OS · ${summary.lastIssueDate}`
            : 'Sem ordens'
        }));
        this.applyFilters();
        this.loading = false;
      },
      error: () => {
        this.error = 'Erro ao carregar o CRM de clientes.';
        this.loading = false;
      }
    });
  }

  applyFilters(): void {
    const normalize = (value: string | undefined) =>
      (value || '').toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g, '');

    this.customers = this.allCustomers.filter((summary) => {
      const customer = summary.customer;
      const matchesName = !this.nameFilter || normalize(customer.name).includes(normalize(this.nameFilter));
      const matchesCpf = !this.cpfFilter || normalize(customer.cpf).includes(normalize(this.cpfFilter));
      const matchesPhone = !this.phoneFilter || normalize(customer.phone).includes(normalize(this.phoneFilter));

      return matchesName && matchesCpf && matchesPhone;
    });
  }

  clearFilters(): void {
    this.nameFilter = '';
    this.cpfFilter = '';
    this.phoneFilter = '';
    this.applyFilters();
  }

  openCrm(customerId?: number): void {
    if (customerId) {
      this.router.navigate(['/crm/customers', customerId]);
    }
  }

  formatCurrency(value: number): string {
    return new Intl.NumberFormat('pt-BR', {
      style: 'currency',
      currency: 'BRL'
    }).format(value || 0);
  }

  private buildSummaries(customers: Customer[], orders: ServiceOrder[]): CustomerCrmSummaryView[] {
    return customers
      .map((customer) => {
        const customerOrders = orders.filter((order) => String(order.customerId) === String(customer.id));
        const totalOrders = customerOrders.length;
        const totalSpent = customerOrders.reduce((sum, order) => sum + (order.totalValue || 0), 0);
        const lastOrder = [...customerOrders].sort((a, b) => this.getOrderDateValue(b) - this.getOrderDateValue(a))[0];

        return {
          customer,
          totalOrders,
          totalSpent,
          lastOrderLabel: lastOrder
            ? `OS #${lastOrder.id ?? '—'} · ${lastOrder.issueDate || '—'}`
            : 'Sem ordens'
        };
      })
      .sort((a, b) => a.customer.name.localeCompare(b.customer.name));
  }

  private getOrderDateValue(order: ServiceOrder): number {
    const rawDate = order.issueDate || order.deliveryDate || '';
    const date = new Date(rawDate);
    return Number.isNaN(date.getTime()) ? 0 : date.getTime();
  }
}
