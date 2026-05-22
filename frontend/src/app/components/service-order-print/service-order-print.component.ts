import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceOrder } from '../../models/service-order.model';
import html2pdf from 'html2pdf.js';

@Component({
  selector: 'app-service-order-print',
  templateUrl: './service-order-print.component.html',
  styleUrls: ['./service-order-print.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class ServiceOrderPrintComponent implements OnInit {
  @Input() order: ServiceOrder | null = null;
  @Input() visible = false;
  @Output() closed = new EventEmitter<void>();

  storeName = 'DK VISION';
  storePhone = '(81) 99546-0155';
  storeAddress = 'Rua Francisco Alves, 325 - SL 04. Ilha do Leite Recife/PE';
  storeCep = 'CEP: 50070-490';
  storeInstagram = '@oticadkvision';

  ngOnInit(): void {
    if (this.visible && this.order) {
      setTimeout(() => this.previewPrint(), 100);
    }
  }

  previewPrint(): void {
    window.print();
  }

  generatePdf(): void {
    const element = document.getElementById('print-content');
    if (!element) return;

    const opt = {
      margin: 0,
      filename: `OS-${this.order?.id || 'SEM-ID'}.pdf`,
      image: { type: 'jpeg' as 'jpeg' | 'png' | 'webp', quality: 1 },
      html2canvas: {
        scale: 1.5,
        useCORS: true,
        scrollY: 0,
        windowWidth: 794 // A5 proporcional em px
      },
      jsPDF: {unit: 'mm', format: 'a5', orientation: 'portrait' as const }
    };

    html2pdf().set(opt).from(element).save();
    this.close();
  }

  close(): void {
    this.closed.emit();
  }
}
