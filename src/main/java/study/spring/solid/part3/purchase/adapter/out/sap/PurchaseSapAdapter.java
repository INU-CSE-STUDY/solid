package study.spring.solid.part3.purchase.adapter.out.sap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.spring.solid.part3.purchase.application.port.out.PurchaseSapPort;
import study.spring.solid.part3.purchase.domain.KJ_Purchase;
import study.spring.solid.part3.sap.mapper.KJ_SapMapper;
import study.spring.solid.part3.sap.service.SapClient;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class PurchaseSapAdapter implements PurchaseSapPort {

    private final SapClient client;
    private final KJ_SapMapper mapper;

    @Override
    public UUID save(KJ_Purchase purchase) {
        return client.getId(mapper.toDto(purchase));
    }
}
