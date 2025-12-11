package study.spring.solid.part1.application.service.kj.calculator;

import org.springframework.stereotype.Component;
import study.spring.solid.part1.application.prot.in.KJ_CalculateStrategy;
import study.spring.solid.part1.doamin.CalculateOperation;

@Component
public class KJ_Div implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {

        if (op2 != 0) return op1 / op2;

        throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }

    @Override
    public CalculateOperation getOperator() {
        return CalculateOperation.DIV;
    }
}