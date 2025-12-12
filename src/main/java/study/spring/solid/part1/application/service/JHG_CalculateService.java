package study.spring.solid.part1.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part1.application.prot.in.CalculateUseCase;
import study.spring.solid.part1.application.service.calculator.JHG_CalculatorDelegator;
import study.spring.solid.part1.application.service.calculator.JHG_CalculatorProcessor;
import study.spring.solid.part1.doamin.CalculateOperation;

@Service
@Profile("JHG")
@RequiredArgsConstructor
public class JHG_CalculateService implements CalculateUseCase {

    private final JHG_CalculatorDelegator delegator;

    @Override
    public long calculate(CalculateOperation operation, long op1, long op2) {
        JHG_CalculatorProcessor processor = delegator.getProcessor(operation);
        return processor.calculate(op1, op2);
    }
}
