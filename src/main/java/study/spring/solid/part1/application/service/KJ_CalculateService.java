package study.spring.solid.part1.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part1.application.prot.in.CalculateUseCase;
import study.spring.solid.part1.application.service.kj.calculator.KJ_Calculator;
import study.spring.solid.part1.doamin.CalculateOperation;

@Service
@Profile("KJ")
@RequiredArgsConstructor
public class KJ_CalculateService implements CalculateUseCase {

    private final KJ_Calculator calculator;

    @Override
    public long calculate(CalculateOperation operation, long op1, long op2) {
        return calculator.calculate(operation, op1, op2);
    }
}
