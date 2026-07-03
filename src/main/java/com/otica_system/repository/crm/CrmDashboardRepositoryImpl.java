package com.otica_system.repository.crm;

import com.otica_system.dto.serviceorder.CrmDashboardDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public class CrmDashboardRepositoryImpl implements CrmDashboardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CrmDashboardDTO findDashboardMetrics() {
        Object[] row = (Object[]) entityManager.createNativeQuery(
                "SELECT " +
                        "(SELECT COUNT(*) FROM customers) AS total_clients, " +
                        "(SELECT COUNT(*) FROM service_orders) AS total_service_orders, " +
                        "(SELECT COALESCE(SUM(total_value), 0) FROM service_orders) AS total_revenue, " +
                        "(SELECT CASE WHEN COUNT(*) = 0 THEN 0 ELSE COALESCE(SUM(total_value), 0) / COUNT(*) END FROM service_orders) AS average_ticket, " +
                        "(SELECT COUNT(*) FROM customers c2 WHERE (SELECT COUNT(*) FROM service_orders s2 WHERE s2.customer_id = c2.id) >= 5 OR (SELECT COALESCE(SUM(total_value), 0) FROM service_orders s2 WHERE s2.customer_id = c2.id) >= 1000) AS vip_clients, " +
                        "(SELECT COUNT(*) FROM customers c2 WHERE (SELECT COUNT(*) FROM service_orders s2 WHERE s2.customer_id = c2.id) = 1) AS new_clients, " +
                        "(SELECT COUNT(*) FROM customers c2 WHERE NOT EXISTS (SELECT 1 FROM service_orders s2 WHERE s2.customer_id = c2.id) OR (SELECT MAX(issue_date) FROM service_orders s2 WHERE s2.customer_id = c2.id) < DATE_SUB(CURRENT_DATE(), INTERVAL 180 DAY)) AS inactive_clients, " +
                        "(SELECT COUNT(*) FROM customers c2 WHERE (SELECT COUNT(*) FROM service_orders s2 WHERE s2.customer_id = c2.id) BETWEEN 2 AND 4) AS recurring_clients, " +
                        "(SELECT COUNT(*) FROM customers c2 WHERE c2.birth_date IS NOT NULL AND MONTH(c2.birth_date) = MONTH(CURRENT_DATE())) AS birthdays_this_month, " +
                        "(SELECT COUNT(*) FROM service_orders s2 WHERE s2.status = 'WAITING_LABORATORY') AS waiting_laboratory_orders, " +
                        "(SELECT COUNT(*) FROM service_orders s2 WHERE s2.status = 'AWAITING_PICKUP') AS awaiting_pickup_orders"
                        , Object[].class)
                .getSingleResult();

        return new CrmDashboardDTO(
                toLong(row[0]),
                toLong(row[1]),
                toBigDecimal(row[2]),
                toBigDecimal(row[3]),
                toLong(row[4]),
                toLong(row[5]),
                toLong(row[6]),
                toLong(row[7]),
                toLong(row[8]),
                toLong(row[9]),
                toLong(row[10])
        );
    }

    private Long toLong(Object value) {
        if (value == null) {
            return 0L;
        }
        if (value instanceof BigInteger) {
            return ((BigInteger) value).longValue();
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return Long.parseLong(value.toString());
    }

    private BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }
        if (value instanceof Number) {
            return BigDecimal.valueOf(((Number) value).doubleValue());
        }
        return new BigDecimal(value.toString());
    }
}
