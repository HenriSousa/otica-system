package com.otica_system.dto.serviceorder;

import java.math.BigDecimal;

public class CrmDashboardDTO {

    private Long totalClients;
    private Long totalServiceOrders;
    private BigDecimal totalRevenue;
    private BigDecimal averageTicket;
    private Long vipClients;
    private Long newClients;
    private Long inactiveClients;
    private Long recurringClients;
    private Long birthdaysThisMonth;
    private Long waitingLaboratoryOrders;
    private Long awaitingPickupOrders;

    public CrmDashboardDTO() {
    }

    public CrmDashboardDTO(Long totalClients,
                           Long totalServiceOrders,
                           BigDecimal totalRevenue,
                           BigDecimal averageTicket,
                           Long vipClients,
                           Long newClients,
                           Long inactiveClients,
                           Long recurringClients,
                           Long birthdaysThisMonth,
                           Long waitingLaboratoryOrders,
                           Long awaitingPickupOrders) {
        this.totalClients = totalClients;
        this.totalServiceOrders = totalServiceOrders;
        this.totalRevenue = totalRevenue;
        this.averageTicket = averageTicket;
        this.vipClients = vipClients;
        this.newClients = newClients;
        this.inactiveClients = inactiveClients;
        this.recurringClients = recurringClients;
        this.birthdaysThisMonth = birthdaysThisMonth;
        this.waitingLaboratoryOrders = waitingLaboratoryOrders;
        this.awaitingPickupOrders = awaitingPickupOrders;
    }

    public Long getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(Long totalClients) {
        this.totalClients = totalClients;
    }

    public Long getTotalServiceOrders() {
        return totalServiceOrders;
    }

    public void setTotalServiceOrders(Long totalServiceOrders) {
        this.totalServiceOrders = totalServiceOrders;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getAverageTicket() {
        return averageTicket;
    }

    public void setAverageTicket(BigDecimal averageTicket) {
        this.averageTicket = averageTicket;
    }

    public Long getVipClients() {
        return vipClients;
    }

    public void setVipClients(Long vipClients) {
        this.vipClients = vipClients;
    }

    public Long getNewClients() {
        return newClients;
    }

    public void setNewClients(Long newClients) {
        this.newClients = newClients;
    }

    public Long getInactiveClients() {
        return inactiveClients;
    }

    public void setInactiveClients(Long inactiveClients) {
        this.inactiveClients = inactiveClients;
    }

    public Long getRecurringClients() {
        return recurringClients;
    }

    public void setRecurringClients(Long recurringClients) {
        this.recurringClients = recurringClients;
    }

    public Long getBirthdaysThisMonth() {
        return birthdaysThisMonth;
    }

    public void setBirthdaysThisMonth(Long birthdaysThisMonth) {
        this.birthdaysThisMonth = birthdaysThisMonth;
    }

    public Long getWaitingLaboratoryOrders() {
        return waitingLaboratoryOrders;
    }

    public void setWaitingLaboratoryOrders(Long waitingLaboratoryOrders) {
        this.waitingLaboratoryOrders = waitingLaboratoryOrders;
    }

    public Long getAwaitingPickupOrders() {
        return awaitingPickupOrders;
    }

    public void setAwaitingPickupOrders(Long awaitingPickupOrders) {
        this.awaitingPickupOrders = awaitingPickupOrders;
    }
}
