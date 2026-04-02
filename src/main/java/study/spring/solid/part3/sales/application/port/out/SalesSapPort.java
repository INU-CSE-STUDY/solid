package study.spring.solid.part3.sales.application.port.out;

import study.spring.solid.part3.sales.domain.KJ_Sales;

import java.util.UUID;

public interface SalesSapPort {

    UUID save(KJ_Sales sales);
}
