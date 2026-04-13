package study.spring.solid.part3.purchase.application.port.in;

import study.spring.solid.part3.purchase.domain.KJ_Purchase;

public interface PurchaseUseCase {

    KJ_Purchase processData(CreatePurchaseCommand command);
}
