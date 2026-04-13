package study.spring.solid.part3.purchase.application.port.out;

import study.spring.solid.part3.purchase.domain.KJ_Purchase;

import java.util.UUID;

public interface PurchaseSapPort {

    UUID save(KJ_Purchase purchase);
}
