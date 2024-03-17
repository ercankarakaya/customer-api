package com.ercan.controller;

import com.ercan.dto.CustomerDTO;
import com.ercan.request.AddCustomerRequest;
import com.ercan.request.GetCustomerListByNumberRequest;
import com.ercan.request.SearchCustomerListRequest;
import com.ercan.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer/")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("list")
    public ResponseEntity<List<CustomerDTO>> getAllCustomerList() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("byCustomerNumber")
    public ResponseEntity<List<CustomerDTO>> getCustomerListByNumberRequest(@RequestBody GetCustomerListByNumberRequest request) {
        return ResponseEntity.ok(customerService.findAllByCustomerNumber(request.getCustomerNumber()));
    }

    @GetMapping("search")
    public ResponseEntity<List<CustomerDTO>> searchCustomerList(@RequestBody SearchCustomerListRequest request) {
        return ResponseEntity.ok(customerService.searchCustomerList(request.getSearch()));
    }

    @PostMapping("create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody AddCustomerRequest request) {
        return ResponseEntity.ok(customerService.create(request.getCustomerDTO()));
    }

    @PutMapping("update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody AddCustomerRequest request) {
        return ResponseEntity.ok(customerService.update(request.getCustomerDTO()));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
