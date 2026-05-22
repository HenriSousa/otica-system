package com.otica_system.repository.serviceorder;

import com.otica_system.domain.serviceorder.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    List<ServiceOrder> findByCustomerCpf(String customerCpf);
}
