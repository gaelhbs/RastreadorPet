package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.models.Customer;
import com.senai.rastreadorpet.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacade {

    @Autowired
    private CustomerService customerService;

    public Customer createNewCustomer(Customer customer) {
        return customerService.save(customer);
    }
}
