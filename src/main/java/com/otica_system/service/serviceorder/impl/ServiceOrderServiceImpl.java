package com.otica_system.service.serviceorder.impl;

import com.otica_system.domain.customer.Customer;
import com.otica_system.domain.serviceorder.ServiceOrder;
import com.otica_system.dto.serviceorder.CreateServiceOrderDTO;
import com.otica_system.dto.serviceorder.CustomerCrmSummaryDTO;
import com.otica_system.dto.serviceorder.UpdateServiceOrderDTO;
import com.otica_system.exception.ResourceNotFoundException;
import com.otica_system.repository.customer.CustomerRepository;
import com.otica_system.repository.serviceorder.ServiceOrderRepository;
import com.otica_system.service.crm.CustomerClassificationService;
import com.otica_system.service.serviceorder.ServiceOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceOrderServiceImpl implements ServiceOrderService {

    private final ServiceOrderRepository repository;
    private final CustomerRepository customerRepository;
    private final CustomerClassificationService classificationService;

    public ServiceOrderServiceImpl(ServiceOrderRepository repository, CustomerRepository customerRepository, CustomerClassificationService classificationService) {
        this.repository = repository;
        this.customerRepository = customerRepository;
        this.classificationService = classificationService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiceOrder> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ServiceOrder> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiceOrder> findByCpf(String cpf) {
        return repository.findByCustomerCpf(cpf);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiceOrder> findByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerCrmSummaryDTO> findCustomerCrmSummaries() {
        List<CustomerCrmSummaryDTO> summaries = repository.findCustomerCrmSummaries();
        summaries.forEach(summary -> summary.setCategory(classificationService.classify(summary).toString()));
        return summaries;
    }

    @Override
    public ServiceOrder save(CreateServiceOrderDTO dto) {
        ServiceOrder entity = fromCreateDTO(dto);
        return repository.save(entity);
    }

    @Override
    public ServiceOrder update(UpdateServiceOrderDTO dto) {
        ServiceOrder existing = repository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Ordem de serviço não encontrada com id: " + dto.getId()));
        updateFromDTO(existing, dto);
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ordem de serviço não encontrada com id: " + id);
        }
        repository.deleteById(id);
    }

    private ServiceOrder fromCreateDTO(CreateServiceOrderDTO dto) {
        ServiceOrder serviceOrder = new ServiceOrder();
        updateFromDTO(serviceOrder, dto);
        return serviceOrder;
    }

    private void updateFromDTO(ServiceOrder serviceOrder, CreateServiceOrderDTO dto) {
        if (dto.getCustomerId() != null) {
            Customer customer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getCustomerId()));
            serviceOrder.setCustomer(customer);
        }
        serviceOrder.setCustomerName(dto.getCustomerName());
        serviceOrder.setCustomerPhone(dto.getCustomerPhone());
        serviceOrder.setCustomerCpf(dto.getCustomerCpf());
        serviceOrder.setCustomerBirthDate(dto.getCustomerBirthDate());
        serviceOrder.setCustomerAddress(dto.getCustomerAddress());
        serviceOrder.setCustomerNeighborhood(dto.getCustomerNeighborhood());
        serviceOrder.setCustomerReferencePoint(dto.getCustomerReferencePoint());
        serviceOrder.setIssueDate(dto.getIssueDate());
        serviceOrder.setDeliveryDate(dto.getDeliveryDate());
        serviceOrder.setFrameType(dto.getFrameType());
        serviceOrder.setFrameBrand(dto.getFrameBrand());
        serviceOrder.setFrameReference(dto.getFrameReference());
        serviceOrder.setFrameColor(dto.getFrameColor());
        serviceOrder.setRightEyeSphere(dto.getRightEyeSphere());
        serviceOrder.setRightEyeCylinder(dto.getRightEyeCylinder());
        serviceOrder.setRightEyeAxis(dto.getRightEyeAxis());
        serviceOrder.setLeftEyeSphere(dto.getLeftEyeSphere());
        serviceOrder.setLeftEyeCylinder(dto.getLeftEyeCylinder());
        serviceOrder.setLeftEyeAxis(dto.getLeftEyeAxis());
        serviceOrder.setAd(dto.getAd());
        serviceOrder.setDp(dto.getDp());
        serviceOrder.setDnp(dto.getDnp());
        serviceOrder.setLensType(dto.getLensType());
        serviceOrder.setObservations(dto.getObservations());
        serviceOrder.setSignature(dto.getSignature());
        serviceOrder.setFrameValue(dto.getFrameValue());
        serviceOrder.setLensValue(dto.getLensValue());
        serviceOrder.setSunglassesValue(dto.getSunglassesValue());
        serviceOrder.setRepairValue(dto.getRepairValue());
        serviceOrder.setOtherValue(dto.getOtherValue());
        serviceOrder.setTotalValue(dto.getTotalValue());
        serviceOrder.setDownPayment(dto.getDownPayment());
        serviceOrder.setRemainingBalance(dto.getRemainingBalance());
        serviceOrder.setPaymentMethod(dto.getPaymentMethod());
        serviceOrder.setStatus(dto.getStatus());
    }

    private void updateFromDTO(ServiceOrder serviceOrder, UpdateServiceOrderDTO dto) {
        if (dto.getCustomerId() != null) {
            Customer customer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getCustomerId()));
            serviceOrder.setCustomer(customer);
        }
        serviceOrder.setCustomerName(dto.getCustomerName());
        serviceOrder.setCustomerPhone(dto.getCustomerPhone());
        serviceOrder.setCustomerCpf(dto.getCustomerCpf());
        serviceOrder.setCustomerBirthDate(dto.getCustomerBirthDate());
        serviceOrder.setCustomerAddress(dto.getCustomerAddress());
        serviceOrder.setCustomerNeighborhood(dto.getCustomerNeighborhood());
        serviceOrder.setCustomerReferencePoint(dto.getCustomerReferencePoint());
        serviceOrder.setIssueDate(dto.getIssueDate());
        serviceOrder.setDeliveryDate(dto.getDeliveryDate());
        serviceOrder.setFrameType(dto.getFrameType());
        serviceOrder.setFrameBrand(dto.getFrameBrand());
        serviceOrder.setFrameReference(dto.getFrameReference());
        serviceOrder.setFrameColor(dto.getFrameColor());
        serviceOrder.setRightEyeSphere(dto.getRightEyeSphere());
        serviceOrder.setRightEyeCylinder(dto.getRightEyeCylinder());
        serviceOrder.setRightEyeAxis(dto.getRightEyeAxis());
        serviceOrder.setLeftEyeSphere(dto.getLeftEyeSphere());
        serviceOrder.setLeftEyeCylinder(dto.getLeftEyeCylinder());
        serviceOrder.setLeftEyeAxis(dto.getLeftEyeAxis());
        serviceOrder.setAd(dto.getAd());
        serviceOrder.setDp(dto.getDp());
        serviceOrder.setDnp(dto.getDnp());
        serviceOrder.setLensType(dto.getLensType());
        serviceOrder.setObservations(dto.getObservations());
        serviceOrder.setSignature(dto.getSignature());
        serviceOrder.setFrameValue(dto.getFrameValue());
        serviceOrder.setLensValue(dto.getLensValue());
        serviceOrder.setSunglassesValue(dto.getSunglassesValue());
        serviceOrder.setRepairValue(dto.getRepairValue());
        serviceOrder.setOtherValue(dto.getOtherValue());
        serviceOrder.setTotalValue(dto.getTotalValue());
        serviceOrder.setDownPayment(dto.getDownPayment());
        serviceOrder.setRemainingBalance(dto.getRemainingBalance());
        serviceOrder.setPaymentMethod(dto.getPaymentMethod());
        serviceOrder.setStatus(dto.getStatus());
    }
}
