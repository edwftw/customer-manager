package org.demo.entity

import spock.lang.Specification
import spock.lang.Unroll

class CustomerSpec extends Specification {

    def "Should generate lastName field when the same is empty" () {
        given: "A valid customer"
        Customer customer = new Customer()
        customer.setLastName("")

        when: "generate lastName is called"
        customer.generateLastName()

        then: "lastName must be filled"
        customer.lastName == "last name generated"
    }

    def "Should keep lastName when the same is filled" () {
        given: "A valid customer"
        Customer customer = new Customer()
        customer.setLastName("Last Name")

        when: "generate lastName is called"
        customer.generateLastName()

        then: "lastName must be filled"
        customer.lastName == "Last Name"
    }

    @Unroll
    def "Should validate lastName field #lastName" () {
        given: "A valid customer"
        Customer customer = new Customer()
        customer.setLastName(lastName)

        when: "generate lastName is called"
        customer.generateLastName()

        then:
        customer.lastName == result

        where: "with parameters"
        lastName    || result
        ""          || "last name generated"
        "Last Name" || "Last Name"

    }

}
