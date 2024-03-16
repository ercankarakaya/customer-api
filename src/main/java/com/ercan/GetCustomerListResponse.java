package com.ercan;

import com.ercan.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetCustomerListResponse {
    private List<CustomerDTO> customerDTOList;
}
