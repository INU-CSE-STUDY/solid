package study.spring.solid.part1.application.service.jem;

import org.springframework.stereotype.Component;
import study.spring.solid.part1.doamin.CalculateOperation;

@Component
public class DivideCalculate implements CalculateProcessor {
    @Override
    public boolean compareOperation(CalculateOperation operation) {
        return CalculateOperation.DIV == operation;
    }
    @Override
    public long calculate(CalculateOperation operation, long op1, long op2) {
        if(op2 == 0) throw new RuntimeException("0으로 나눌 수 없습니다.");
        return op1 / op2;
    }
}
