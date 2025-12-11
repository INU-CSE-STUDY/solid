package study.spring.solid.part1.application.service.kj.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.spring.solid.part1.application.prot.in.KJ_CalculateStrategy;
import study.spring.solid.part1.doamin.CalculateOperation;

import java.util.*;

@Component
@RequiredArgsConstructor
public class KJ_Calculator {

    private final List<KJ_CalculateStrategy> strategies;

    public long calculate(CalculateOperation operation, long op1, long op2) {

        for (KJ_CalculateStrategy strategy : strategies) {

            if (strategy.support(operation)) {
                return strategy.calculate(op1, op2);
            }
        }

        throw new IllegalArgumentException(operation + "은(는) 지원하지 않는 연산자입니다.");
    }
}
