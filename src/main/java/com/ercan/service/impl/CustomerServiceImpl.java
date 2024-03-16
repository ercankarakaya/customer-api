package com.ercan.service.impl;

import com.ercan.dto.CustomerDTO;
import com.ercan.repository.CustomerRepository;
import com.ercan.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> findAll() {
        return null;
    }

    @Override
    public List<CustomerDTO> findAllByCustomerNumber(Long customerNumber) {
        return null;
    }

    @Override
    public List<CustomerDTO> searchCustomerList(String searchValue) {
        return null;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
