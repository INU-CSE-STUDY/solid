package study.spring.solid.part1.application.service.kj.calculator;

import org.springframework.stereotype.Component;
import study.spring.solid.part1.application.prot.in.KJ_CalculateStrategy;
import study.spring.solid.part1.doamin.CalculateOperation;

import java.util.*;

@Component
public class KJ_Calculator {

    private final Map<CalculateOperation, KJ_CalculateStrategy> strategyMap;

    public KJ_Calculator(List<KJ_CalculateStrategy> strategies) {

        this.strategyMap = new HashMap<>();

        for (KJ_CalculateStrategy strategy : strategies) {
            strategyMap.put(strategy.getOperator(), strategy);
        }
    }

    public long calculate(CalculateOperation operation, long op1, long op2) {

        KJ_CalculateStrategy strategy = strategyMap.get(operation);
        if (strategy == null) throw new IllegalArgumentException("지원하지 않는 연산입니다.");

        return strategy.calculate(op1, op2);
    }
}

@Component
class KJ_Add implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {
        return op1 + op2;
    }

    @Override
    public CalculateOperation getOperator() {
        return CalculateOperation.ADD;
    }
}

@Component
class KJ_Sub implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {
        return op1 - op2;
    }

    @Override
    public CalculateOperation getOperator() {
        return CalculateOperation.SUB;
    }
}

@Component
class KJ_Mul implements KJ_CalculateStrategy {

    @Override
    public long calculate(long op1, long op2) {
        return op1 * op2;
    }

    @Override
    public CalculateOperation getOperator() {
        return CalculateOperation.MUL;
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
    public CalculateOperation getOperator() {
        return CalculateOperation.DIV;
    }
}
