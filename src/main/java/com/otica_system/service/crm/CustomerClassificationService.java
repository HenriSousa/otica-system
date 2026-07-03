package com.otica_system.service.crm;

import com.otica_system.dto.serviceorder.CustomerCrmSummaryDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CustomerClassificationService {

    private static final BigDecimal VIP_SPENDING_THRESHOLD = BigDecimal.valueOf(1000);
    private static final long INACTIVE_DAYS_THRESHOLD = 180;

    public CustomerCategory classify(CustomerCrmSummaryDTO summary) {
        if (isInactive(summary.getLastIssueDate())) {
            return CustomerCategory.Inativo;
        }

        if (isVip(summary.getTotalOrders(), summary.getTotalSpent())) {
            return CustomerCategory.VIP;
        }

        if (isRecurring(summary.getTotalOrders())) {
            return CustomerCategory.Recorrente;
        }

        return CustomerCategory.Novo;
    }

    private boolean isInactive(LocalDate lastIssueDate) {
        if (lastIssueDate == null) {
            return true;
        }

        long daysSinceLastOrder = ChronoUnit.DAYS.between(lastIssueDate, LocalDate.now());
        return daysSinceLastOrder > INACTIVE_DAYS_THRESHOLD;
    }

    private boolean isVip(Long totalOrders, BigDecimal totalSpent) {
        return (totalOrders != null && totalOrders >= 5)
                || (totalSpent != null && totalSpent.compareTo(VIP_SPENDING_THRESHOLD) > 0);
    }

    private boolean isRecurring(Long totalOrders) {
        return totalOrders != null && totalOrders >= 2 && totalOrders <= 4;
    }
}
