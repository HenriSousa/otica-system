import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceOrder } from '../../models/service-order.model';
import { ServiceOrderService } from '../../services/service-order.service';

@Component({
  selector: 'app-service-order-view',
  templateUrl: './service-order-view.component.html',
  styleUrls: ['./service-order-view.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class ServiceOrderViewComponent implements OnInit {

  order?: ServiceOrder;
  loading = true;
  errorMessage = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: ServiceOrderService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!id) {
      this.errorMessage = 'Ordem de serviço inválida.';
      this.loading = false;
      return;
    }

    this.service.findById(id).subscribe({
      next: order => {
        this.order = order;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Não foi possível carregar a ordem de serviço.';
        this.loading = false;
      }
    });
  }

  back() {
    this.router.navigate(['/service-orders']);
  }

  edit() {
    if (this.order?.id) {
      this.router.navigate([`/service-orders/${this.order.id}/edit`]);
    }
  }
}
