package com.otica_system.dto.serviceorder;

import com.otica_system.domain.serviceorder.PaymentMethod;
import com.otica_system.domain.serviceorder.ServiceOrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ServiceOrderDTO {

    private Long id;
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String customerCpf;
    private String customerRg;
    private LocalDate customerBirthDate;
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

    public ServiceOrderDTO() {
    }

    public ServiceOrderDTO(Long id, Long customerId, String customerName, String customerPhone, String customerCpf, String customerRg, LocalDate customerBirthDate, String customerAddress, String customerNeighborhood, String customerReferencePoint, LocalDate issueDate, LocalDate deliveryDate, String frameType, String frameBrand, String frameReference, String frameColor, String rightEyeSphere, String rightEyeCylinder, String rightEyeAxis, String leftEyeSphere, String leftEyeCylinder, String leftEyeAxis, String ad, String dp, String dnp, String lensType, String observations, String signature, BigDecimal frameValue, BigDecimal lensValue, BigDecimal sunglassesValue, BigDecimal repairValue, BigDecimal otherValue, BigDecimal totalValue, BigDecimal downPayment, BigDecimal remainingBalance, PaymentMethod paymentMethod, ServiceOrderStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerCpf = customerCpf;
        this.customerRg = customerRg;
        this.customerBirthDate = customerBirthDate;
        this.customerAddress = customerAddress;
        this.customerNeighborhood = customerNeighborhood;
        this.customerReferencePoint = customerReferencePoint;
        this.issueDate = issueDate;
        this.deliveryDate = deliveryDate;
        this.frameType = frameType;
        this.frameBrand = frameBrand;
        this.frameReference = frameReference;
        this.frameColor = frameColor;
        this.rightEyeSphere = rightEyeSphere;
        this.rightEyeCylinder = rightEyeCylinder;
        this.rightEyeAxis = rightEyeAxis;
        this.leftEyeSphere = leftEyeSphere;
        this.leftEyeCylinder = leftEyeCylinder;
        this.leftEyeAxis = leftEyeAxis;
        this.ad = ad;
        this.dp = dp;
        this.dnp = dnp;
        this.lensType = lensType;
        this.observations = observations;
        this.signature = signature;
        this.frameValue = frameValue;
        this.lensValue = lensValue;
        this.sunglassesValue = sunglassesValue;
        this.repairValue = repairValue;
        this.otherValue = otherValue;
        this.totalValue = totalValue;
        this.downPayment = downPayment;
        this.remainingBalance = remainingBalance;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCustomerRg() {
        return customerRg;
    }

    public void setCustomerRg(String customerRg) {
        this.customerRg = customerRg;
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
