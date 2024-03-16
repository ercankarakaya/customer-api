package com.ercan.mapper;

import com.ercan.dto.CustomerDTO;
import com.ercan.entity.Customer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Named("toCustomer")
    Customer toCustomer(CustomerDTO customerDTO);

    @Named("toCustomerDTO")
    CustomerDTO toCustomerDTO(Customer customer);

    @IterableMapping(qualifiedByName = "toCustomer")
    List<Customer> toCustomerList(List<CustomerDTO> customerDTOList);

    @IterableMapping(qualifiedByName = "toCustomerDTO")
    List<CustomerDTO> toCustomerDTOList(List<Customer> customerList);
}
