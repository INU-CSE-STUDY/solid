package study.spring.solid.part3.sales.application.port.in;

import study.spring.solid.part3.sales.domain.Sales;

public interface SalesUseCase {

    Sales processData(CreateSalesCommand command);
}
