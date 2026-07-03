import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationEnd, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-crm-layout',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './crm-layout.component.html',
  styleUrls: ['./crm-layout.component.scss']
})
export class CrmLayoutComponent {
  readonly navItems = [
    { label: 'Dashboard', icon: '📊', route: '/crm/dashboard' },
    { label: 'Clientes', icon: '👥', route: '/crm/customers' },
    { label: 'Aniversariantes', icon: '🎂', route: '/crm', disabled: true },
    { label: 'Aguardando Retirada', icon: '📦', route: '/crm', disabled: true },
    { label: 'Laboratório', icon: '🧪', route: '/crm', disabled: true },
    { label: 'Campanhas', icon: '📢', route: '/crm', disabled: true },
    { label: 'Relatórios', icon: '📈', route: '/crm', disabled: true },
    { label: 'Configurações', icon: '⚙', route: '/crm', disabled: true }
  ];

  currentPageLabel = 'Dashboard';

  constructor(private router: Router) {
    this.router.events
      .pipe(filter((event): event is NavigationEnd => event instanceof NavigationEnd))
      .subscribe((event) => {
        this.currentPageLabel = this.getPageLabel(event.urlAfterRedirects);
      });

    this.currentPageLabel = this.getPageLabel(this.router.url);
  }

  private getPageLabel(url: string): string {
    return url.includes('/crm/customers') ? 'Clientes' : 'Dashboard';
  }
}
