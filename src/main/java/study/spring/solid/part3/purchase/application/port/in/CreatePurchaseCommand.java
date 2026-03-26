package study.spring.solid.part3.purchase.application.port.in;

import lombok.RequiredArgsConstructor;
import study.spring.solid.part3.purchase.domain.Purchase;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreatePurchaseCommand {

    private final BigDecimal price;
    private final String name;
    private final String vendorName;
    private final BigDecimal amount;

    public Purchase of() {
        return new Purchase(
                null,
                price,
                name,
                vendorName,
                amount
        );
    }
}
