package study.spring.solid.part1.application.service.calculator;

import org.springframework.stereotype.Component;
import study.spring.solid.part1.doamin.CalculateOperation;

@Component
public class JHG_MulCalculateProcessor implements JHG_CalculatorProcessor {
    @Override
    public boolean support(CalculateOperation operation) {
        return CalculateOperation.MUL.equals(operation);
    }

    @Override
    public long calculate(long op1, long op2) {
        return op1 * op2;
    }
}
