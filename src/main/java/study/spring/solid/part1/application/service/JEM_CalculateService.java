package study.spring.solid.part1.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part1.application.prot.in.CalculateUseCase;
import study.spring.solid.part1.application.service.jem.CalculateDelegator;
import study.spring.solid.part1.doamin.CalculateOperation;

@Profile("JEM")
@RequiredArgsConstructor
@Service
public class JEM_CalculateService implements CalculateUseCase {
    private final CalculateDelegator calculateDelegator;

    @Override
    public long calculate(CalculateOperation operation, long op1, long op2) {
        return calculateDelegator.calculate(operation, op1, op2);
    }
}
