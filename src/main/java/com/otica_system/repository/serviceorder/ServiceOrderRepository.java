package com.otica_system.repository.serviceorder;

import com.otica_system.domain.serviceorder.ServiceOrder;
import com.otica_system.dto.serviceorder.CustomerCrmSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    List<ServiceOrder> findByCustomerCpf(String customerCpf);

    List<ServiceOrder> findByCustomerId(Long customerId);

    @Query("select new com.otica_system.dto.serviceorder.CustomerCrmSummaryDTO(" +
            "c.id, c.name, c.phone, c.cpf, count(s.id), coalesce(sum(s.totalValue), 0), max(s.issueDate)) " +
            "from Customer c left join ServiceOrder s on s.customer = c " +
            "group by c.id, c.name, c.phone, c.cpf " +
            "order by c.name")
    List<CustomerCrmSummaryDTO> findCustomerCrmSummaries();
}
