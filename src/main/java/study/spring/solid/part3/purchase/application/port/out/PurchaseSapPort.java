package study.spring.solid.part3.purchase.application.port.out;

import study.spring.solid.part3.purchase.domain.Purchase;

import java.util.UUID;

public interface PurchaseSapPort {

    UUID save(Purchase purchase);
}
