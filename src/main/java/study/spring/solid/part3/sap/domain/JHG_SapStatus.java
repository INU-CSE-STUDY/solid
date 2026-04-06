package study.spring.solid.part3.sap.domain;

import java.math.BigDecimal;

public interface JHG_SapStatus {

    default BigDecimal getAmount() {
        return null;
    }

    default BigDecimal getPrice() {
        return null;
    }
}
