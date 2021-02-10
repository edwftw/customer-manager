package org.demo.usecase;

import org.springframework.stereotype.Service;

@Service
public class CalculateDriverEligibilityUseCase {

    public boolean execute(Integer age) throws Exception {
        if(age == null) {
            throw new Exception("Unable to calculate driver eligibility");
        }

        return age > 18;
    }
}
