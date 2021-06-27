package com.Facturel.Controller;

import com.Facturel.Model.CustomerDTO;
import com.Facturel.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController
{
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomer()
    {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerDTO customerDTO)
    {
        customerService.addCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(name = "id") Integer id)
    {
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable(name = "id") Integer id, @RequestBody CustomerDTO customerDTO)
    {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));
    }

}
