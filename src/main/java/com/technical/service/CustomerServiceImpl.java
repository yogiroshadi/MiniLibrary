package com.technical.service;

import com.technical.customerror.NotFoundException;
import com.technical.dto.customer.InsertCustomerDTO;
import com.technical.dto.customer.UpdateCustomerDTO;
import com.technical.entity.Account;
import com.technical.entity.Customer;
import com.technical.entity.Role;
import com.technical.repository.AccountRepository;
import com.technical.repository.CustomerRepository;
import com.technical.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer registerCustomer(InsertCustomerDTO dto) {

        String encryptedPassword = passwordEncoder.encode(dto.getPassword());

        Role role = roleRepository.findByRole("Customer")
                .orElseThrow(() -> new NotFoundException("Role Customer not found!"));

        Customer newCustomer = new Customer(
                dto.getName(),
                dto.getEmail(),
                dto.getUsername()
        );

        Account newAccount = new Account(
                dto.getUsername(),
                encryptedPassword,
                role.getId()
        );

        accountRepository.save(newAccount);
        Customer registeredCustomer = customerRepository.save(newCustomer);

        return registeredCustomer;
    }

    @Override
    public Customer updateCustomer(String username, UpdateCustomerDTO dto) {
        Customer customer = customerRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(
                        "Customer with username " + username + " is not exist!"));

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());

        Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }
}
