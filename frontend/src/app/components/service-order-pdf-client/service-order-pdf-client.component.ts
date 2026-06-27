import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceOrder } from '../../models/service-order.model';
import html2pdf from 'html2pdf.js';

@Component({
  selector: 'app-service-order-pdf-client',
  templateUrl: './service-order-pdf-client.component.html',
  styleUrls: ['./service-order-pdf-client.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class ServiceOrderPdfClientComponent implements OnChanges {
  @Input() order: ServiceOrder | null = null;
  @Input() visible = false;
  @Output() closed = new EventEmitter<void>();

  storeName = 'DK VISION';
  storePhone = '(81) 99546-0155';
  storeAddress = 'Rua Francisco Alves, 325 - SL 04';
  storeAddressLine2 = 'Ilha do Leite - Recife/PE';
  storeCep = 'CEP 50070-490';
  storeInstagram = '@oticadkvision';

  ngOnChanges(changes: SimpleChanges): void {
    const visibleChange = changes['visible'];
    
    if (visibleChange && visibleChange.currentValue === true && !visibleChange.firstChange) {
      if (this.order) {
        console.log('PDF Client generation started');
        setTimeout(() => this.generatePdf(), 100);
      }
    }
  }

  generatePdf(): void {
    const element = document.getElementById('pdf-client-content');
    if (!element) {
      console.error('PDF Client content element not found');
      return;
    }

    const opt = {
      margin: [10, 10, 10, 10] as [number, number, number, number],
      filename: `OS-Cliente-${this.order?.id || 'SEM-ID'}.pdf`,
      image: { type: 'jpeg' as 'jpeg' | 'png' | 'webp', quality: 0.98 },
      html2canvas: { scale: 2 },
      jsPDF: { format: 'a4', orientation: 'portrait' as const }
    };

    html2pdf()
      .set(opt)
      .from(element)
      .save()
      .then(() => {
        console.log('PDF Client generated and downloaded successfully');
        this.close();
      })
      .catch((error: any) => {
        console.error('Error generating PDF Client:', error);
        this.close();
      });
  }

  close(): void {
    this.closed.emit();
  }
}
