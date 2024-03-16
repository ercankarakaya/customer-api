package com.ercan.service.impl;

import com.ercan.dto.CustomerDTO;
import com.ercan.entity.Customer;
import com.ercan.mapper.CustomerMapper;
import com.ercan.repository.CustomerRepository;
import com.ercan.service.CustomerService;
import com.ercan.specification.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> findAll() {
        return customerMapper.toCustomerDTOList(customerRepository.findAll());
    }

    @Override
    public List<CustomerDTO> findAllByCustomerNumber(Long customerNumber) {
        final Specification<Customer> customerSpecification = CustomerSpecification.hasCustomerNumber(customerNumber);
        return customerMapper.toCustomerDTOList(customerRepository.findAll(customerSpecification));
    }

    @Override
    public List<CustomerDTO> searchCustomerList(String searchValue) {
        final Specification<Customer> customerSpecification = CustomerSpecification.searchCustomer(searchValue);
        return customerMapper.toCustomerDTOList(customerRepository.findAll(customerSpecification));
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(customerMapper.toCustomer(customerDTO));
        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Optional<Customer> customer = customerRepository.findById(customerDTO.getId());
        if (customer.isPresent()) {
            Customer updateCustomer = customer.get();
            updateCustomer.setFirstName(customerDTO.getFirstName());
            updateCustomer.setLastName(customerDTO.getLastName());
            updateCustomer.setCustomerNumber(customerDTO.getCustomerNumber());
            return customerMapper.toCustomerDTO(customerRepository.save(updateCustomer));
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
