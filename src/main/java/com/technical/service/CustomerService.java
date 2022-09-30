package com.technical.service;

import com.technical.dto.customer.InsertCustomerDTO;
import com.technical.dto.customer.UpdateCustomerDTO;
import com.technical.entity.Customer;

public interface CustomerService {
    Customer registerCustomer(InsertCustomerDTO dto);

    Customer updateCustomer(String username, UpdateCustomerDTO dto);
}
