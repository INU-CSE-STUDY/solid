package study.spring.solid.part3.purchase.application.port.in;

import lombok.RequiredArgsConstructor;
import study.spring.solid.part3.purchase.domain.KJ_Purchase;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreatePurchaseCommand {

    private final BigDecimal price;
    private final String name;
    private final String vendorName;
    private final BigDecimal amount;

    public KJ_Purchase of() {
        return new KJ_Purchase(
                null,
                price,
                name,
                vendorName,
                amount
        );
    }
}
