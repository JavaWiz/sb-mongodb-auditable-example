package com.javawiz.controller;

import com.javawiz.model.Customer;
import com.javawiz.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable String id){
        return ResponseEntity.ok(customerRepository.findById(id).orElseThrow());
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id){
        customerRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        customerRepository.deleteAll();
    }
}
