package study.spring.solid.part1.application.service.calculator;

import study.spring.solid.part1.doamin.CalculateOperation;

public interface JHG_CalculatorProcessor {

    boolean support(CalculateOperation operation);

    long calculate(long op1, long op2);
}
