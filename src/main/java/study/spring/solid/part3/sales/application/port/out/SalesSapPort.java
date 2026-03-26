package study.spring.solid.part3.sales.application.port.out;

import study.spring.solid.part3.sales.domain.Sales;

import java.util.UUID;

public interface SalesSapPort {

    UUID save(Sales sales);
}
