import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../models/customer.model';

@Component({
  selector: 'app-customer-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.scss']
})
export class CustomerFormComponent implements OnInit {

  form!: FormGroup;
  loading = false;
  submitting = false;
  error: string | null = null;
  isEditMode = false;
  customerId: number | null = null;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.initializeForm();
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.isEditMode = true;
        this.customerId = +id;
        this.loadCustomer(this.customerId);
      }
    });
  }

  initializeForm(): void {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      phone: ['', [Validators.required, Validators.minLength(10)]],
      cpf: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
      birthDate: [''],
      address: ['', [Validators.required, Validators.minLength(5)]],
      neighborhood: [''],
      referencePoint: ['']
    });
  }

  loadCustomer(id: number): void {
    this.loading = true;
    this.customerService.findById(id).subscribe({
      next: (customer) => {
        this.form.patchValue(customer);
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erro ao carregar cliente';
        console.error(err);
        this.loading = false;
      }
    });
  }

  submit(): void {
    if (this.form.invalid) {
      this.error = 'Preencha todos os campos obrigatórios corretamente';
      return;
    }

    this.submitting = true;
    this.error = null;

    const formData = this.form.value;

    if (this.isEditMode && this.customerId) {
      this.customerService.update(this.customerId, formData).subscribe({
        next: () => {
          this.router.navigate(['/customers']);
        },
        error: (err) => {
          this.error = 'Erro ao atualizar cliente';
          console.error(err);
          this.submitting = false;
        }
      });
    } else {
      this.customerService.create(formData).subscribe({
        next: () => {
          this.router.navigate(['/customers']);
        },
        error: (err) => {
          this.error = 'Erro ao criar cliente';
          console.error(err);
          this.submitting = false;
        }
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/customers']);
  }

  get name() {
    return this.form.get('name');
  }

  get phone() {
    return this.form.get('phone');
  }

  get cpf() {
    return this.form.get('cpf');
  }

  get birthDate() {
    return this.form.get('birthDate');
  }

  get address() {
    return this.form.get('address');
  }

  get neighborhood() {
    return this.form.get('neighborhood');
  }

  get referencePoint() {
    return this.form.get('referencePoint');
  }
}
