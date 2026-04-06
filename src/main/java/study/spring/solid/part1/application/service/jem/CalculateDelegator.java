package study.spring.solid.part1.application.service.jem;

import org.springframework.stereotype.Component;
import study.spring.solid.part1.doamin.CalculateOperation;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculateDelegator {
    private final List<CalculateProcessor> calculators;

    public CalculateDelegator() {
        this.calculators = new ArrayList<>();
        calculators.add(new DivideCalculate());
        calculators.add(new MultiplyCalculate());
        calculators.add(new AddCalculate());
        calculators.add(new SubtractCalculate());
    }

    public long calculate(CalculateOperation operation, long op1, long op2) {
        return calculators.stream()
                .filter(calculator -> calculator.compareOperation(operation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("지원하지 않는 연산자입니다."))
                .calculate(operation, op1, op2);
    }
}
