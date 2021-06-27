package com.Facturel.Model.Adaptors;

import com.Facturel.Model.CustomerDTO;
import com.Facturel.Repository.Customers.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerAdapter
{

    public static Customer fromDto(CustomerDTO customerDTO)
    {
        return new Customer()
                .setName(customerDTO.getName())
                .setCui(customerDTO.getCui())
                .setOwner(customerDTO.getOwner())
                .setPhone(customerDTO.getPhone());
    }

    public static CustomerDTO toDto(Customer customer)
    {
        return new CustomerDTO()
                .setId(customer.getId())
                .setName(customer.getName())
                .setCui(customer.getCui())
                .setOwner(customer.getOwner())
                .setPhone(customer.getPhone());
    }

    public static List<Customer> customerListFromDto(List<CustomerDTO> customerDTOS)
    {
        List<Customer> customerList = new ArrayList<>();
        customerDTOS.forEach(customerDTO -> customerList.add(fromDto(customerDTO)));
        return customerList;
    }

    public static List<CustomerDTO> customerListToDto(List<Customer> customers)
    {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customers.forEach(customer -> customerDTOS.add(toDto(customer)));
        return customerDTOS;
    }
}
