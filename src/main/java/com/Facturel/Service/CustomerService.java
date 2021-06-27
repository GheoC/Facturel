package com.Facturel.Service;

import com.Facturel.Model.Adaptors.CustomerAdapter;
import com.Facturel.Model.CustomerDTO;
import com.Facturel.Repository.Customers.Customer;
import com.Facturel.Repository.Customers.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class CustomerService
{
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAll()
    {
        return customerRepository.findAll()
                .stream()
                .map(customer -> CustomerAdapter.toDto(customer))
                .collect(Collectors.toList());
    }

    public void addCustomer(@Valid CustomerDTO customerDTO)
    {
        if (customerRepository.findByCui(customerDTO.getCui())!=null)
        {
            throw new RuntimeException("Customer is allready define");
        }
        customerRepository.save(CustomerAdapter.fromDto(customerDTO));
    }

    public void deleteCustomer(Integer id)
    {
        customerRepository.deleteById(id);
    }

    public CustomerDTO updateCustomer(Integer id, @Valid CustomerDTO customerDTO)
    {
        Customer customer = customerRepository.getById(id);

        if (customer==null)
        {
            throw new RuntimeException("Customer is not yet defined");
        }
        customer.setName(customerDTO.getName())
                .setCui(customerDTO.getCui())
                .setOwner(customerDTO.getOwner())
                .setPhone(customerDTO.getPhone());

        customerRepository.save(customer);
        return CustomerAdapter.toDto(customer);
    }
}
