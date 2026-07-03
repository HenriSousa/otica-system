package com.otica_system.repository.crm;

import com.otica_system.dto.serviceorder.CrmDashboardDTO;

public interface CrmDashboardRepository {
    CrmDashboardDTO findDashboardMetrics();
}
