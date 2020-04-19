package org.demo.interfaceadapters.database.mongo;

import org.demo.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    public Customer save(Customer customer);

    public List<Customer> getCustomers();
}
