package study.spring.solid.part1.application.service.jem;

import org.springframework.stereotype.Component;
import study.spring.solid.part1.doamin.CalculateOperation;

@Component
public class AddCalculate implements CalculateProcessor {
    @Override
    public boolean compareOperation(CalculateOperation operation) {
        return CalculateOperation.ADD == operation;
    }
    @Override
    public long calculate(CalculateOperation operation, long op1, long op2) {
        return op1 + op2;
    }
}
