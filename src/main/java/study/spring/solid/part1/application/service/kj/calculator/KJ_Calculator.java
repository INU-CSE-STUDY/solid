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
