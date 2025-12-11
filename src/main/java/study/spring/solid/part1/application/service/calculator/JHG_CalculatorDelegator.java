package study.spring.solid.part1.application.service.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.spring.solid.part1.doamin.CalculateOperation;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JHG_CalculatorDelegator {

    private final List<JHG_CalculatorProcessor> processors;

    public JHG_CalculatorProcessor getProcessor(CalculateOperation operation) {
        return processors.stream()
                .filter(processor -> processor.support(operation))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
