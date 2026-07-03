package com.otica_system.controller.crm;

import com.otica_system.dto.serviceorder.CrmDashboardDTO;
import com.otica_system.service.crm.CrmDashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crm")
public class CrmDashboardController {

    private final CrmDashboardService service;

    public CrmDashboardController(CrmDashboardService service) {
        this.service = service;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<CrmDashboardDTO> getDashboardMetrics() {
        CrmDashboardDTO metrics = service.findDashboardMetrics();
        return ResponseEntity.ok(metrics);
    }
}
