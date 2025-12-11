package study.spring.solid.part1.application.service.kj.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.spring.solid.part1.application.prot.in.KJ_CalculateStrategy;
import study.spring.solid.part1.doamin.CalculateOperation;

import java.util.*;

@Component
@RequiredArgsConstructor
public class KJ_Calculator {

    private final List<KJ_CalculateStrategy> operations;

    public long calculate(CalculateOperation operation, long op1, long op2) {

        for (KJ_CalculateStrategy op : operations) {

            if (op.isSameOperator(operation)) {
                return op.calculate(op1, op2);
            }
        }

        throw new IllegalArgumentException("지원하지 않는 연산입니다.");
    }
}

@Component
class KJ_Add implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {
        return op1 + op2;
    }

    @Override
    public boolean isSameOperator(CalculateOperation operation) {
        return CalculateOperation.ADD.equals(operation);
    }
}

@Component
class KJ_Sub implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {
        return op1 - op2;
    }

    @Override
    public boolean isSameOperator(CalculateOperation operation) {
        return CalculateOperation.SUB.equals(operation);
    }
}

@Component
class KJ_Mul implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {
        return op1 * op2;
    }

    @Override
    public boolean isSameOperator(CalculateOperation operation) {
        return CalculateOperation.MUL.equals(operation);
    }
}

@Component
class KJ_Div implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {

        if (op2 != 0) return op1 / op2;

        throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }

    @Override
    public boolean isSameOperator(CalculateOperation operation) {
        return CalculateOperation.DIV.equals(operation);
    }
}
