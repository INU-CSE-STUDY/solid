package study.spring.solid.part3.sales.application.port.in;

import study.spring.solid.part3.sales.domain.KJ_Sales;

public interface SalesUseCase {

    KJ_Sales processData(CreateSalesCommand command);
}
