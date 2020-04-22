package org.demo.interfaceadapters.database.mongo;

import org.demo.entity.Customer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private MongoTemplate mongoTemplate;

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
