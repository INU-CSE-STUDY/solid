package study.spring.solid.part1.application.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part1.application.prot.in.CalculateUseCase;
import study.spring.solid.part1.doamin.CalculateOperation;

@Service
@Profile("JHG")
public class JHG_CalculateService implements CalculateUseCase {

    @Override
    public long calculate(CalculateOperation operation, long op1, long op2) {
        return 1;
    }
}
