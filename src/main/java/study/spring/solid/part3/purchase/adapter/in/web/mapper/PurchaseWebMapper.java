package study.spring.solid.part3.purchase.adapter.in.web.mapper;

import org.springframework.stereotype.Component;
import study.spring.solid.part3.purchase.adapter.in.web.dto.CreatePurchaseDto;
import study.spring.solid.part3.purchase.adapter.in.web.dto.PurchaseDto;
import study.spring.solid.part3.purchase.application.port.in.CreatePurchaseCommand;
import study.spring.solid.part3.purchase.domain.KJ_Purchase;

@Component
public class PurchaseWebMapper {

    public CreatePurchaseCommand toCommand(CreatePurchaseDto dto) {
        return new CreatePurchaseCommand(
                dto.getPrice(),
                dto.getName(),
                dto.getVendorName(),
                dto.getAmount()
        );
    }

    public PurchaseDto toDto(KJ_Purchase purchase) {
        return new PurchaseDto(
                purchase.getId(),
                purchase.getPrice(),
                purchase.getName(),
                purchase.getVendorName(),
                purchase.getAmount()
        );
    }
}
