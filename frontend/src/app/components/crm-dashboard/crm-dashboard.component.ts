import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { forkJoin } from 'rxjs';
import { CrmService, CrmDashboardMetrics } from '../../services/crm.service';

@Component({
  selector: 'app-crm-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './crm-dashboard.component.html',
  styleUrls: ['./crm-dashboard.component.scss']
})
export class CrmDashboardComponent implements OnInit {
  metrics: CrmDashboardMetrics = {
    totalClients: 0,
    totalServiceOrders: 0,
    totalRevenue: 0,
    averageTicket: 0,
    vipClients: 0,
    newClients: 0,
    inactiveClients: 0,
    recurringClients: 0,
    birthdaysThisMonth: 0,
    waitingLaboratoryOrders: 0,
    awaitingPickupOrders: 0
  };
  loading = false;
  error = '';

  constructor(
    private crmService: CrmService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadMetrics();
  }

  loadMetrics(): void {
    this.loading = true;
    this.error = '';

    this.crmService.getDashboardMetrics().subscribe({
      next: (dashboard) => {
        this.metrics = dashboard;
        this.loading = false;
      },
      error: () => {
        this.error = 'Falha ao carregar métricas do CRM.';
        this.loading = false;
      }
    });
  }

  formatCurrency(value: number): string {
    return new Intl.NumberFormat('pt-BR', {
      style: 'currency',
      currency: 'BRL'
    }).format(value || 0);
  }

  refresh(): void {
    this.loadMetrics();
  }

  openWaitingLaboratory(): void {
    this.router.navigate(['/service-orders'], { queryParams: { status: 'WAITING_LABORATORY' } });
  }

  openAwaitingPickup(): void {
    this.router.navigate(['/service-orders'], { queryParams: { status: 'AWAITING_PICKUP' } });
  }

}
