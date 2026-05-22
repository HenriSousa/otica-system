import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceOrder } from '../../models/service-order.model';
import { ServiceOrderService } from '../../services/service-order.service';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-service-order-form',
  templateUrl: './service-order-form.component.html',
  styleUrls: ['./service-order-form.component.scss'],
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule]
})
export class ServiceOrderFormComponent implements OnInit {

  form: FormGroup;
  id?: number;
  isEditMode = false;
  submitting = false;
  errorMessage = '';
  fieldErrors: Record<string, string> = {};

  paymentMethods = [
    { value: 'PIX', label: 'PIX' },
    { value: 'DINHEIRO', label: 'Dinheiro' },
    { value: 'CARTAO_CREDITO', label: 'Cartão de Crédito' },
    { value: 'CARTAO_DEBITO', label: 'Cartão de Débito' }
  ];

  statusOptions = [
    { value: 'OPEN', label: 'Aberta' },
    { value: 'IN_PROGRESS', label: 'Em andamento' },
    { value: 'READY', label: 'Pronta' },
    { value: 'DELIVERED', label: 'Entregue' },
    { value: 'CANCELED', label: 'Cancelada' }
  ];

  constructor(
    private fb: FormBuilder,
    private service: ServiceOrderService,
    private customerService: CustomerService,
    public router: Router,
    private route: ActivatedRoute
  ) {
    this.form = this.fb.group({
      id: [null],
      customerCpf: ['', Validators.required],
      customerName: ['', Validators.required],
      customerPhone: ['', Validators.required],
      customerAddress: ['', Validators.required],
      customerRg: [''],
      customerBirthDate: [''],
      customerNeighborhood: [''],
      customerReferencePoint: [''],
      issueDate: [''],
      deliveryDate: [''],

      frameType: [''],
      frameBrand: [''],
      frameReference: [''],
      frameColor: [''],

      rightEyeSphere: [''],
      rightEyeCylinder: [''],
      rightEyeAxis: [''],
      leftEyeSphere: [''],
      leftEyeCylinder: [''],
      leftEyeAxis: [''],

      ad: [''],
      dp: [''],
      dnp: [''],
      lensType: [''],

      observations: [''],
      signature: [''],

      frameValue: [0],
      lensValue: [0],
      sunglassesValue: [0],
      repairValue: [0],
      otherValue: [0],
      totalValue: [0],
      downPayment: [0],
      remainingBalance: [0],
      paymentMethod: ['PIX'],
      status: ['OPEN']
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      this.isEditMode = !!idParam;
      if (idParam) {
        this.id = +idParam;
        this.service.findById(this.id).subscribe(o => this.form.patchValue(o));
      }
    });
  }

  buscarCpf() {
    const cpf = this.form.get('customerCpf')?.value;
    if (!cpf) return;
    this.customerService.findByCpf(cpf).subscribe(c => {
      this.form.patchValue({
        customerName: c.name,
        customerPhone: c.phone,
        customerAddress: c.address,
        customerNeighborhood: c.neighborhood,
        customerReferencePoint: c.referencePoint,
        customerBirthDate: c.birthDate
      });
    }, () => {
      alert('Cliente não encontrado para o CPF informado');
    });
  }

  back() {
    this.router.navigate(['/service-orders']);
  }

  save() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.errorMessage = 'Preencha todos os campos obrigatórios antes de salvar.';
      return;
    }

    this.submitting = true;
    this.errorMessage = '';
    this.fieldErrors = {};
    const value: ServiceOrder = this.form.value;

    if (this.isEditMode && this.id) {
      value.id = this.id;
    }

    const request = this.isEditMode && this.id
      ? this.service.update(this.id, value)
      : this.service.create(value);

    request.subscribe({
      next: () => this.router.navigate(['/service-orders']),
      error: err => {
        this.submitting = false;
        this.fieldErrors = {};

        const payload = err?.error;
        if (payload && typeof payload === 'object' && !Array.isArray(payload)) {
          if (payload.message) {
            this.errorMessage = payload.message;
          }
          Object.keys(payload).forEach(key => {
            if (key !== 'message') {
              this.fieldErrors[key] = payload[key];
            }
          });
          if (!this.errorMessage) {
            this.errorMessage = 'Alguns campos estão inválidos. Veja as mensagens abaixo.';
          }
        } else {
          this.errorMessage = 'Falha ao salvar a ordem de serviço. Verifique os dados e tente novamente.';
        }
      }
    });
  }

  getControl(name: string) {
    return this.form.get(name);
  }

  isInvalid(name: string) {
    const control = this.getControl(name);
    return !!control && (control.invalid && control.touched || !!this.fieldErrors[name]);
  }

  getFieldError(name: string) {
    return this.fieldErrors[name];
  }
}
