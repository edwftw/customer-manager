package org.demo.interfaceadapters.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.demo.entity.Customer
import org.demo.usecase.CustomerUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@WebMvcTest(CustomerController.class)
class CustomerControllerSpec extends Specification {

    @MockBean
    CustomerUseCase customerUseCase

    @Autowired
    ObjectMapper objectMapper

    @Autowired
    MockMvc mockMvc

    def "should get customers" () {

        customerUseCase.getCustomers() >> getCustomersMock()

        when: "end point is called"
        def response = mockMvc.perform(get("/customers")).andReturn()

        then: "response "
        response.response.status == 200
    }

    def "should post customer" () {

        Customer customer = new Customer()
        customer.setFirstName("First Name")
        customer.setLastName("Last Name")
        customer.setAge(30)

        when: "end point is called"
        def response = mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getCustomerJson(customer)))
                        .andReturn()

        then: "response "
        response.response.status == 200

    }

    def getCustomersMock() {
        Customer customer = new Customer()
        customer.setId("123")
        customer.setFirstName("First Name")
        customer.setLastName("Last Name")
        customer.setAge(30)

        List<Customer> customers = new ArrayList<>()
        customers.add(customer)

        return customers
    }

    def getCustomerJson(Customer customer) {
        try {
            return new ObjectMapper().writeValueAsString(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
