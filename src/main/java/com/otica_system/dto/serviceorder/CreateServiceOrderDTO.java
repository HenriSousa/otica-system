package com.otica_system.dto.serviceorder;

import com.otica_system.domain.serviceorder.PaymentMethod;
import com.otica_system.domain.serviceorder.ServiceOrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateServiceOrderDTO {

    private Long customerId;

    @NotBlank(message = "Nome do cliente é obrigatório")
    private String customerName;

    @NotBlank(message = "Telefone do cliente é obrigatório")
    private String customerPhone;

    @NotBlank(message = "CPF do cliente é obrigatório")
    private String customerCpf;

    private LocalDate customerBirthDate;

    @NotBlank(message = "Endereço do cliente é obrigatório")
    private String customerAddress;

    private String customerNeighborhood;
    private String customerReferencePoint;
    private LocalDate issueDate;
    private LocalDate deliveryDate;
    private String frameType;
    private String frameBrand;
    private String frameReference;
    private String frameColor;
    private String rightEyeSphere;
    private String rightEyeCylinder;
    private String rightEyeAxis;
    private String leftEyeSphere;
    private String leftEyeCylinder;
    private String leftEyeAxis;
    private String ad;
    private String dp;
    private String dnp;
    private String lensType;
    private String observations;
    private String signature;
    private BigDecimal frameValue;
    private BigDecimal lensValue;
    private BigDecimal sunglassesValue;
    private BigDecimal repairValue;
    private BigDecimal otherValue;
    private BigDecimal totalValue;
    private BigDecimal downPayment;
    private BigDecimal remainingBalance;
    private PaymentMethod paymentMethod;
    private ServiceOrderStatus status;

    public CreateServiceOrderDTO() {
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

    public LocalDate getCustomerBirthDate() {
        return customerBirthDate;
    }

    public void setCustomerBirthDate(LocalDate customerBirthDate) {
        this.customerBirthDate = customerBirthDate;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNeighborhood() {
        return customerNeighborhood;
    }

    public void setCustomerNeighborhood(String customerNeighborhood) {
        this.customerNeighborhood = customerNeighborhood;
    }

    public String getCustomerReferencePoint() {
        return customerReferencePoint;
    }

    public void setCustomerReferencePoint(String customerReferencePoint) {
        this.customerReferencePoint = customerReferencePoint;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public String getFrameBrand() {
        return frameBrand;
    }

    public void setFrameBrand(String frameBrand) {
        this.frameBrand = frameBrand;
    }

    public String getFrameReference() {
        return frameReference;
    }

    public void setFrameReference(String frameReference) {
        this.frameReference = frameReference;
    }

    public String getFrameColor() {
        return frameColor;
    }

    public void setFrameColor(String frameColor) {
        this.frameColor = frameColor;
    }

    public String getRightEyeSphere() {
        return rightEyeSphere;
    }

    public void setRightEyeSphere(String rightEyeSphere) {
        this.rightEyeSphere = rightEyeSphere;
    }

    public String getRightEyeCylinder() {
        return rightEyeCylinder;
    }

    public void setRightEyeCylinder(String rightEyeCylinder) {
        this.rightEyeCylinder = rightEyeCylinder;
    }

    public String getRightEyeAxis() {
        return rightEyeAxis;
    }

    public void setRightEyeAxis(String rightEyeAxis) {
        this.rightEyeAxis = rightEyeAxis;
    }

    public String getLeftEyeSphere() {
        return leftEyeSphere;
    }

    public void setLeftEyeSphere(String leftEyeSphere) {
        this.leftEyeSphere = leftEyeSphere;
    }

    public String getLeftEyeCylinder() {
        return leftEyeCylinder;
    }

    public void setLeftEyeCylinder(String leftEyeCylinder) {
        this.leftEyeCylinder = leftEyeCylinder;
    }

    public String getLeftEyeAxis() {
        return leftEyeAxis;
    }

    public void setLeftEyeAxis(String leftEyeAxis) {
        this.leftEyeAxis = leftEyeAxis;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getDnp() {
        return dnp;
    }

    public void setDnp(String dnp) {
        this.dnp = dnp;
    }

    public String getLensType() {
        return lensType;
    }

    public void setLensType(String lensType) {
        this.lensType = lensType;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public BigDecimal getFrameValue() {
        return frameValue;
    }

    public void setFrameValue(BigDecimal frameValue) {
        this.frameValue = frameValue;
    }

    public BigDecimal getLensValue() {
        return lensValue;
    }

    public void setLensValue(BigDecimal lensValue) {
        this.lensValue = lensValue;
    }

    public BigDecimal getSunglassesValue() {
        return sunglassesValue;
    }

    public void setSunglassesValue(BigDecimal sunglassesValue) {
        this.sunglassesValue = sunglassesValue;
    }

    public BigDecimal getRepairValue() {
        return repairValue;
    }

    public void setRepairValue(BigDecimal repairValue) {
        this.repairValue = repairValue;
    }

    public BigDecimal getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(BigDecimal otherValue) {
        this.otherValue = otherValue;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ServiceOrderStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }
}
