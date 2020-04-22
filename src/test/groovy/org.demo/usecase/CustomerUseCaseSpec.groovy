package org.demo.usecase

import org.demo.entity.Customer
import org.demo.interfaceadapters.database.mongo.CustomerRepository
import spock.lang.Specification

class CustomerUseCaseSpec extends Specification {

    CustomerRepository customerRepository = Mock()

    CustomerUseCase customerUseCase = new CustomerUseCase(customerRepository)

    def "Should save a customer" () {
        given: "A valid customer"
        Customer customer = new Customer()
        customer.setLastName("lastName")

        when: "customer use case is called"
        customerUseCase.save(customer)

        then: "repository must be called"
        1 * customerRepository.save(customer)
    }
}
