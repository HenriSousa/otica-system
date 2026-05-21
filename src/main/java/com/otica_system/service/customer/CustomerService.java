package com.otica_system.service.customer;

import com.otica_system.dto.customer.CreateCustomerDTO;
import com.otica_system.dto.customer.CustomerDTO;
import com.otica_system.dto.customer.UpdateCustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO create(CreateCustomerDTO dto);

    CustomerDTO update(Long id, UpdateCustomerDTO dto);

    void delete(Long id);

    CustomerDTO findById(Long id);

    List<CustomerDTO> findAll();
}
