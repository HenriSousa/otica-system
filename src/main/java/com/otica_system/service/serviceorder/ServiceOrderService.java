package com.otica_system.service.serviceorder;

import com.otica_system.domain.serviceorder.ServiceOrder;
import com.otica_system.dto.serviceorder.CreateServiceOrderDTO;
import com.otica_system.dto.serviceorder.UpdateServiceOrderDTO;

import java.util.List;
import java.util.Optional;

public interface ServiceOrderService {

    List<ServiceOrder> findAll();

    Optional<ServiceOrder> findById(Long id);

    List<ServiceOrder> findByCpf(String cpf);

    ServiceOrder save(CreateServiceOrderDTO createServiceOrderDTO);

    ServiceOrder update(UpdateServiceOrderDTO updateServiceOrderDTO);

    void delete(Long id);
}
