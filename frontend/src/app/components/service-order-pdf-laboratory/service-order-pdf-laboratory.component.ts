import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceOrder } from '../../models/service-order.model';
import html2pdf from 'html2pdf.js';

@Component({
  selector: 'app-service-order-pdf-laboratory',
  templateUrl: './service-order-pdf-laboratory.component.html',
  styleUrls: ['./service-order-pdf-laboratory.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class ServiceOrderPdfLaboratoryComponent implements OnChanges {
  @Input() order: ServiceOrder | null = null;
  @Input() visible = false;
  @Output() closed = new EventEmitter<void>();

  storeName = 'DK VISION';

  ngOnChanges(changes: SimpleChanges): void {
    const visibleChange = changes['visible'];
    
    if (visibleChange && visibleChange.currentValue === true && !visibleChange.firstChange) {
      if (this.order) {
        console.log('PDF Laboratory generation started');
        setTimeout(() => this.generatePdf(), 100);
      }
    }
  }

  generatePdf(): void {
    const element = document.getElementById('pdf-lab-content');
    if (!element) {
      console.error('PDF Laboratory content element not found');
      return;
    }

    const opt = {
      margin: [5, 5, 5, 5] as [number, number, number, number],
      filename: `OS-Laboratorio-${this.order?.id || 'SEM-ID'}.pdf`,
      image: { type: 'jpeg' as 'jpeg' | 'png' | 'webp', quality: 0.98 },
      html2canvas: { scale: 2 },
      jsPDF: { format: 'a5', orientation: 'portrait' as const }
    };

    html2pdf()
      .set(opt)
      .from(element)
      .save()
      .then(() => {
        console.log('PDF Laboratory generated and downloaded successfully');
        this.close();
      })
      .catch((error: any) => {
        console.error('Error generating PDF Laboratory:', error);
        this.close();
      });
  }

  close(): void {
    this.closed.emit();
  }

  getLensValue(): number {
    return this.order?.lensValue || 0;
  }

  getServiceValue(): number {
    const repair = this.order?.repairValue || 0;
    const others = this.order?.otherValue || 0;
    return repair + others;
  }
}
