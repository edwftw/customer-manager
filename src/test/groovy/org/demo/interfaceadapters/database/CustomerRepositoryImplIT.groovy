package org.demo.interfaceadapters.database

import org.demo.entity.Customer
import org.demo.interfaceadapters.database.mongo.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.core.MongoTemplate
import spock.lang.Specification

@DataMongoTest
@ComponentScan(basePackages = "org.demo")
class CustomerRepositoryImplIT extends Specification {

    @Autowired
    MongoTemplate mongoTemplate

    @Autowired
    CustomerRepository customerRepository

    def setup() {
        mongoTemplate.dropCollection("customers")

        Customer customer = new Customer()
        customer.setFirstName("First Name")
        customer.setLastName("Last Name")
        customer.setAge(30)

        mongoTemplate.save(customer, "customers")
    }

    def "Find customers in repository with success" () {

        when: "service is called"
        List<Customer> customers = customerRepository.getCustomers()

        then: "must be found"
        customers.size() > 0
    }

    def "Save customer in repository with success" () {
        given: "a customer"
        Customer customer = new Customer()
        customer.setFirstName("First Name")
        customer.setLastName("Last Name")
        customer.setAge(30)

        when: "service is called"
        Customer result = customerRepository.save(customer)

        then: "must be saved"
        !result.id.isEmpty()
    }

}
