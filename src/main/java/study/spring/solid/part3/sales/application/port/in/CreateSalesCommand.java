package study.spring.solid.part3.sales.application.port.in;

import lombok.RequiredArgsConstructor;
import study.spring.solid.part3.sales.domain.Sales;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreateSalesCommand {

    private final BigDecimal price;
    private final String name;
    private final String description;
    private final BigDecimal amount;

    public Sales of() {
        return new Sales(
                null,
                price,
                name,
                description,
                amount
        );
    }
}
