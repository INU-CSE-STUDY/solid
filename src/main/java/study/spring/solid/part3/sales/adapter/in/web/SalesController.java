package study.spring.solid.part3.sales.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.solid.part3.sales.adapter.in.web.dto.CreateSalesDto;
import study.spring.solid.part3.sales.adapter.in.web.dto.SalesDto;
import study.spring.solid.part3.sales.adapter.in.web.mapper.SalesWebMapper;
import study.spring.solid.part3.sales.application.port.in.SalesUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SalesController {

    private final SalesUseCase salesUseCase;
    private final SalesWebMapper mapper;


    @PostMapping("/sales")
    public SalesDto processData(@RequestBody CreateSalesDto dto) {
        return mapper.toDto(
                salesUseCase.processData(mapper.toCommand(dto))
        );
    }
}
