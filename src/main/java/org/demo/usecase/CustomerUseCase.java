package org.demo.usecase;

import lombok.extern.slf4j.Slf4j;
import org.demo.entity.Customer;
import org.demo.interfaceadapters.database.mongo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerUseCase {

    private final CustomerRepository customerRepository;
    private final ValidateDriverEligibilityUseCase calculateDriverEligibilityUseCase;

    public CustomerUseCase(final CustomerRepository customerRepository, final ValidateDriverEligibilityUseCase calculateDriverEligibilityUseCase) {
        this.customerRepository = customerRepository;
        this.calculateDriverEligibilityUseCase = calculateDriverEligibilityUseCase;
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer save(Customer customer) throws Exception {
        log.info("Customer: {}", customer.toString());

        customer.generateLastName();

        customer.setDriver(calculateDriverEligibilityUseCase.execute(customer.getAge()));

        return customerRepository.save(customer);
    }
}
