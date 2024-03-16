package com.ercan.request;

import com.ercan.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCustomerRequest {
    private CustomerDTO customerDTO;
}
