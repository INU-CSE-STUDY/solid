package study.spring.solid.part3.sap.mapper;

import org.springframework.stereotype.Component;
import study.spring.solid.part3.sap.KJ_SapDataProvider;
import study.spring.solid.part3.sap.dto.SapSendDto;

@Component
public class KJ_SapMapper {

    public SapSendDto toDto(KJ_SapDataProvider sapDataProvider){
        return new SapSendDto(
                sapDataProvider.getAmount(),
                sapDataProvider.getPrice()
        );
    }
}
