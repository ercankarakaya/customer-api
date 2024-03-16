package com.ercan.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Long customerNumber;
}
