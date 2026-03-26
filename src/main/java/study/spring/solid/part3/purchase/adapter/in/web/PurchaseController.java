package study.spring.solid.part3.purchase.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.solid.part3.purchase.adapter.in.web.dto.CreatePurchaseDto;
import study.spring.solid.part3.purchase.adapter.in.web.dto.PurchaseDto;
import study.spring.solid.part3.purchase.adapter.in.web.mapper.PurchaseWebMapper;
import study.spring.solid.part3.purchase.application.port.in.PurchaseUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PurchaseController {

    private final PurchaseUseCase purchaseUseCase;
    private final PurchaseWebMapper mapper;


    @PostMapping("/purchase")
    public PurchaseDto processData(@RequestBody CreatePurchaseDto dto) {
        return mapper.toDto(
                purchaseUseCase.processData(mapper.toCommand(dto))
        );
    }
}
