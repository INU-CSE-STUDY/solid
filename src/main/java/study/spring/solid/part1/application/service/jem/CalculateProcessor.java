package study.spring.solid.part1.application.service.jem;

import study.spring.solid.part1.doamin.CalculateOperation;

public interface CalculateProcessor {
    boolean compareOperation(CalculateOperation operation);
    long calculate(CalculateOperation operation, long op1, long op2);
}
