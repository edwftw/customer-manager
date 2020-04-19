package org.demo.interfaceadapters.database.mongo;

import org.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private MongoTemplate mongoTemplate;

    @Autowired
    public CustomerRepositoryImpl(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Customer save(Customer customer) {
        return mongoTemplate.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return mongoTemplate.findAll(Customer.class);
    }
}
