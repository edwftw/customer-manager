package org.demo.usecase

import spock.lang.Specification
import spock.lang.Unroll

class ValidateDriverEligibilityUseCaseSpec extends Specification {

     ValidateDriverEligibilityUseCase useCase = new ValidateDriverEligibilityUseCase()

    @Unroll
    def "Should return #scenario" () {
        given: "a age"
        Integer age = ageMock

        when: "the use case is called"
        boolean result = useCase.execute(age)

        then: "the age must be validated"
        result == expected

        where: "with parameters"
        scenario    | ageMock | expected
        "valid"     | 20      | true
        "invalid"   | 18      | false
    }

    def "Should return exception" () {
        given: "a age"
        Integer age = null

        when: "the use case is called"
        useCase.execute(age)

        then: "the age must be validated"
        thrown(Exception)
    }
}
