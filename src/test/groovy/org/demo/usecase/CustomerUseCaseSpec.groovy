package org.demo.usecase

import org.demo.entity.Customer
import org.demo.interfaceadapters.database.mongo.CustomerRepository
import spock.lang.Specification

class CustomerUseCaseSpec extends Specification {

    CustomerRepository customerRepository = Mock()

    ValidateDriverEligibilityUseCase validateDriverEligibilityUseCase = Mock()

    CustomerUseCase customerUseCase = new CustomerUseCase(customerRepository, validateDriverEligibilityUseCase)

    def "Should get customers" () {
        customerRepository.getCustomers() >> Arrays.asList(new Customer())

        when: "use case is called"
        def customers = customerUseCase.getCustomers()

        then: "customers must be returned"
        customers.size() > 0
    }

    def "Should save a customer" () {
        given: "A valid customer"
        Customer customer = new Customer()
        customer.setLastName("lastName")
        customer.setAge(20)

        when: "customer use case is called"
        customerUseCase.save(customer)

        then: "repository must be called"
        1 * customerRepository.save(customer)

        1 * validateDriverEligibilityUseCase.execute(customer.getAge()) >> { args ->
            def ageParameter = args[0]
            assert ageParameter == 20
        }
    }
}
