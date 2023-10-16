package com.javawiz;

import com.javawiz.model.Customer;
import com.javawiz.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    Customer dave, oliver, carter;

    @BeforeAll
    public void setUp() {
        repository.deleteAll();
        dave = repository.save(new Customer("Dave", "Matthews"));
        oliver = repository.save(new Customer("Oliver August", "Matthews"));
        carter = repository.save(new Customer("Carter", "Beauford"));
    }

    @Test
    public void setsIdOnSave() {

        Customer dave = repository.save(new Customer("Dave", "Matthews"));

        assertThat(dave.getId()).isNotNull();
    }

    @Test
    public void findsByLastName() {
        List<Customer> result = repository.findByLastName("Beauford");
        assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
    }

    @Test
    public void findsByExample() {
        Customer probe = new Customer(null, "Matthews");
        List<Customer> result = repository.findAll(Example.of(probe));
        assertThat(result).hasSize(3).extracting("firstName").contains("Dave", "Oliver August");
    }
}