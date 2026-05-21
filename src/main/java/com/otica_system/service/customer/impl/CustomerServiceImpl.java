package com.otica_system.service.customer.impl;

import com.otica_system.domain.customer.Customer;
import com.otica_system.dto.customer.CreateCustomerDTO;
import com.otica_system.dto.customer.CustomerDTO;
import com.otica_system.dto.customer.UpdateCustomerDTO;
import com.otica_system.exception.ResourceNotFoundException;
import com.otica_system.repository.customer.CustomerRepository;
import com.otica_system.service.customer.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerDTO create(CreateCustomerDTO dto) {
        Customer customer = new Customer(
                dto.getName(),
                dto.getPhone(),
                dto.getCpf(),
                dto.getBirthDate(),
                dto.getAddress(),
                dto.getNeighborhood(),
                dto.getReferencePoint()
        );

        Customer saved = repository.save(customer);
        return toDTO(saved);
    }

    @Override
    public CustomerDTO update(Long id, UpdateCustomerDTO dto) {
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        existing.setName(dto.getName());
        existing.setPhone(dto.getPhone());
        existing.setCpf(dto.getCpf());
        existing.setBirthDate(dto.getBirthDate());
        existing.setAddress(dto.getAddress());
        existing.setNeighborhood(dto.getNeighborhood());
        existing.setReferencePoint(dto.getReferencePoint());

        Customer updated = repository.save(existing);
        return toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDTO findById(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return toDTO(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CustomerDTO toDTO(Customer c) {
        return new CustomerDTO(
                c.getId(),
                c.getName(),
                c.getPhone(),
                c.getCpf(),
                c.getBirthDate(),
                c.getAddress(),
                c.getNeighborhood(),
                c.getReferencePoint()
        );
    }
}
