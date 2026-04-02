package study.spring.solid.part3.purchase.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part3.purchase.application.port.in.CreatePurchaseCommand;
import study.spring.solid.part3.purchase.application.port.in.PurchaseUseCase;
import study.spring.solid.part3.purchase.application.port.out.PurchaseSapPort;
import study.spring.solid.part3.purchase.domain.KJ_Purchase;

import java.util.UUID;

@Service
@Profile("KJ")
@RequiredArgsConstructor
public class KJ_PurchaseService implements PurchaseUseCase {

    private final PurchaseSapPort purchaseSapPort;

    @Override
    public KJ_Purchase processData(CreatePurchaseCommand command) {
        KJ_Purchase purchase = command.of();

        UUID id = purchaseSapPort.save(purchase);

        return purchase.processId(id);
    }
}
