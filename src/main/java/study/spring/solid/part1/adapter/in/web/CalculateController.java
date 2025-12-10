package study.spring.solid.part1.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.solid.part1.adapter.in.web.dto.CalculateDto;
import study.spring.solid.part1.application.prot.in.CalculateUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CalculateController {

    private final CalculateUseCase calculateUseCase;

    @GetMapping("/actions/calculate")
    public long calculate(@RequestBody CalculateDto dto){
        return calculateUseCase.calculate(
                dto.operation,
                dto.operator1,
                dto.operator2
        );
    }
}
