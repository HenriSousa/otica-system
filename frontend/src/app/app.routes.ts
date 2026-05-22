import { Routes } from '@angular/router';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { CustomerFormComponent } from './components/customer-form/customer-form.component';
import { ServiceOrderListComponent } from './components/service-order-list/service-order-list.component';
import { ServiceOrderFormComponent } from './components/service-order-form/service-order-form.component';
import { ServiceOrderViewComponent } from './components/service-order-view/service-order-view.component';

export const routes: Routes = [
  { path: '', redirectTo: '/customers', pathMatch: 'full' },
  { path: 'customers', component: CustomerListComponent },
  { path: 'customers/new', component: CustomerFormComponent },
  { path: 'customers/:id/edit', component: CustomerFormComponent },
  { path: 'service-orders', component: ServiceOrderListComponent },
  { path: 'service-orders/new', component: ServiceOrderFormComponent },
  { path: 'service-orders/:id/view', component: ServiceOrderViewComponent },
  { path: 'service-orders/:id/edit', component: ServiceOrderFormComponent },
  { path: '**', redirectTo: '/customers' }
];
