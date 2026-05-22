package com.otica_system.controller.serviceorder;

import com.otica_system.domain.serviceorder.ServiceOrder;
import com.otica_system.dto.serviceorder.CreateServiceOrderDTO;
import com.otica_system.dto.serviceorder.UpdateServiceOrderDTO;
import com.otica_system.service.serviceorder.ServiceOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-orders")
public class ServiceOrderController {

    private final ServiceOrderService service;

    public ServiceOrderController(ServiceOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceOrder> create(@Valid @RequestBody CreateServiceOrderDTO dto) {
        ServiceOrder created = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOrder> update(@PathVariable Long id, @Valid @RequestBody UpdateServiceOrderDTO dto) {
        dto.setId(id);
        ServiceOrder updated = service.update(dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrder> findById(@PathVariable Long id) {
        ServiceOrder serviceOrder = service.findById(id)
                .orElseThrow(() -> new com.otica_system.exception.ResourceNotFoundException("Ordem de serviço não encontrada com id: " + id));
        return ResponseEntity.ok(serviceOrder);
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrder>> findAll() {
        List<ServiceOrder> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/cpf")
    public ResponseEntity<List<ServiceOrder>> findByCpf(@RequestParam String cpf) {
        List<ServiceOrder> result = service.findByCpf(cpf);
        return ResponseEntity.ok(result);
    }
}
