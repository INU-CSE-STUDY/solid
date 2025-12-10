package study.spring.solid.part1.application.prot.in;

import study.spring.solid.part1.doamin.CalculateOperation;

public interface CalculateUseCase {

    long calculate(CalculateOperation operation, long op1, long op2);
}
