package com.otica_system.service.crm.impl;

import com.otica_system.dto.serviceorder.CrmDashboardDTO;
import com.otica_system.dto.serviceorder.CustomerCrmSummaryDTO;
import com.otica_system.repository.crm.CrmDashboardRepository;
import com.otica_system.repository.serviceorder.ServiceOrderRepository;
import com.otica_system.service.crm.CrmDashboardService;
import com.otica_system.service.crm.CustomerClassificationService;
import com.otica_system.service.crm.CustomerCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CrmDashboardServiceImpl implements CrmDashboardService {

    private final CrmDashboardRepository repository;
    private final ServiceOrderRepository serviceOrderRepository;
    private final CustomerClassificationService classificationService;

    public CrmDashboardServiceImpl(CrmDashboardRepository repository,
                                   ServiceOrderRepository serviceOrderRepository,
                                   CustomerClassificationService classificationService) {
        this.repository = repository;
        this.serviceOrderRepository = serviceOrderRepository;
        this.classificationService = classificationService;
    }

    @Override
    public CrmDashboardDTO findDashboardMetrics() {
        CrmDashboardDTO metrics = repository.findDashboardMetrics();
        List<CustomerCrmSummaryDTO> summaries = serviceOrderRepository.findCustomerCrmSummaries();

        long vipClients = summaries.stream()
                .map(classificationService::classify)
                .filter(CustomerCategory.VIP::equals)
                .count();

        long newClients = summaries.stream()
                .map(classificationService::classify)
                .filter(CustomerCategory.Novo::equals)
                .count();

        long inactiveClients = summaries.stream()
                .map(classificationService::classify)
                .filter(CustomerCategory.Inativo::equals)
                .count();

        long recurringClients = summaries.stream()
                .map(classificationService::classify)
                .filter(CustomerCategory.Recorrente::equals)
                .count();

        metrics.setVipClients(vipClients);
        metrics.setNewClients(newClients);
        metrics.setInactiveClients(inactiveClients);
        metrics.setRecurringClients(recurringClients);

        return metrics;
    }
}
