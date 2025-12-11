package study.spring.solid.part1.application.service.kj.calculator;

import org.springframework.stereotype.Component;
import study.spring.solid.part1.application.prot.in.KJ_CalculateStrategy;
import study.spring.solid.part1.doamin.CalculateOperation;

@Component
public class KJ_Mul implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {
        return op1 * op2;
    }

    @Override
    public boolean support(CalculateOperation operation) {
        return CalculateOperation.MUL.equals(operation);
    }
}
