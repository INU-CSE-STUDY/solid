package study.spring.solid.part3.sales.adapter.out.sap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.spring.solid.part3.sales.application.port.out.SalesSapPort;
import study.spring.solid.part3.sales.domain.KJ_Sales;
import study.spring.solid.part3.sap.mapper.KJ_SapMapper;
import study.spring.solid.part3.sap.service.SapClient;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SalesSapAdapter implements SalesSapPort {

    private final SapClient client;
    private final KJ_SapMapper mapper;

    @Override
    public UUID save(KJ_Sales sales) {
        return client.getId(mapper.toDto(sales));
    }
}
