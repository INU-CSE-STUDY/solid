package study.spring.solid.part3.purchase.application.port.in;

import study.spring.solid.part3.purchase.domain.Purchase;

public interface PurchaseUseCase {

    Purchase processData(CreatePurchaseCommand command);
}
