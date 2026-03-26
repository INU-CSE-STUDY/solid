package study.spring.solid.part3.purchase.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.solid.part3.purchase.application.port.in.CreatePurchaseCommand;
import study.spring.solid.part3.purchase.application.port.in.PurchaseUseCase;
import study.spring.solid.part3.purchase.application.port.out.PurchaseSapPort;
import study.spring.solid.part3.purchase.domain.Purchase;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseService implements PurchaseUseCase {

    private final PurchaseSapPort purchaseSapPort;

    @Override
    public Purchase processData(CreatePurchaseCommand command) {
        Purchase purchase = command.of();

        UUID id = purchaseSapPort.save(purchase);

        return purchase.processId(id);
    }
}
