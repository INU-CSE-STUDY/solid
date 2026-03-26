package study.spring.solid.part3.sap.mapper;

import org.springframework.stereotype.Component;
import study.spring.solid.part3.purchase.domain.Purchase;
import study.spring.solid.part3.sales.domain.Sales;
import study.spring.solid.part3.sap.dto.SapSendDto;

@Component
public class SapMapper {

    public SapSendDto toDto(Sales sales){
        return new SapSendDto(
                sales.getAmount(),
                sales.getPrice()
        );
    }

    public SapSendDto toDto(Purchase purchase) {
        return new SapSendDto(
                purchase.getAmount(),
                purchase.getPrice()
        );
    }
}
