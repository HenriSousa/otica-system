import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceOrder } from '../../models/service-order.model';
import { ServiceOrderService } from '../../services/service-order.service';
import { ServiceOrderPrintComponent } from '../service-order-print/service-order-print.component';
import { ServiceOrderPdfClientComponent } from '../service-order-pdf-client/service-order-pdf-client.component';
import { ServiceOrderPdfLaboratoryComponent } from '../service-order-pdf-laboratory/service-order-pdf-laboratory.component';

@Component({
  selector: 'app-service-order-view',
  templateUrl: './service-order-view.component.html',
  styleUrls: ['./service-order-view.component.scss'],
  standalone: true,
  imports: [CommonModule, ServiceOrderPrintComponent, ServiceOrderPdfClientComponent, ServiceOrderPdfLaboratoryComponent]
})
export class ServiceOrderViewComponent implements OnInit {

  order: ServiceOrder | null = null;
  loading = true;
  errorMessage = '';
  showPrint = false;
  showPdfClient = false;
  showPdfLaboratory = false;

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

        const pdfType = this.route.snapshot.queryParamMap.get('pdf');
        if (pdfType === 'client') {
          setTimeout(() => this.openPdfClient(), 150);
        } else if (pdfType === 'laboratory') {
          setTimeout(() => this.openPdfLaboratory(), 150);
        }
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

  openPrint() {
    this.showPrint = true;
  }

  closePrint() {
    this.showPrint = false;
  }

  openPdfClient() {
    this.showPdfClient = true;
  }

  closePdfClient() {
    this.showPdfClient = false;
  }

  openPdfLaboratory() {
    this.showPdfLaboratory = true;
  }

  closePdfLaboratory() {
    this.showPdfLaboratory = false;
  }
}
