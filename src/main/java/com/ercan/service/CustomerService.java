package com.ercan.service;

import com.ercan.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();

    List<CustomerDTO> findAllByCustomerNumber(Long customerNumber);

    List<CustomerDTO> searchCustomerList(String searchValue);

    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO update(CustomerDTO customerDTO);

    void deleteById(Integer id);
}
