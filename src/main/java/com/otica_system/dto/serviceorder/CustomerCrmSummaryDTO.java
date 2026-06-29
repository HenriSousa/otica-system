package com.otica_system.dto.serviceorder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerCrmSummaryDTO {

    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String customerCpf;
    private Long totalOrders;
    private BigDecimal totalSpent;
    private LocalDate lastIssueDate;

    public CustomerCrmSummaryDTO() {
    }

    public CustomerCrmSummaryDTO(Long customerId, String customerName, String customerPhone, String customerCpf, Long totalOrders, BigDecimal totalSpent, LocalDate lastIssueDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerCpf = customerCpf;
        this.totalOrders = totalOrders;
        this.totalSpent = totalSpent;
        this.lastIssueDate = lastIssueDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerCpf() {
        return customerCpf;
    }

    public void setCustomerCpf(String customerCpf) {
        this.customerCpf = customerCpf;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public BigDecimal getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(BigDecimal totalSpent) {
        this.totalSpent = totalSpent;
    }

    public LocalDate getLastIssueDate() {
        return lastIssueDate;
    }

    public void setLastIssueDate(LocalDate lastIssueDate) {
        this.lastIssueDate = lastIssueDate;
    }
}
