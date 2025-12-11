package study.spring.solid.part1.application.prot.in;

import study.spring.solid.part1.doamin.CalculateOperation;

public interface KJ_CalculateStrategy {

    long calculate(long op1, long op2);
    boolean support(CalculateOperation operation);
}