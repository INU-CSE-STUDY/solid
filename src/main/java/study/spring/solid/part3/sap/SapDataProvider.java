package study.spring.solid.part3.sap;

import java.math.BigDecimal;

public interface SapDataProvider {

    BigDecimal getAmount();
    BigDecimal getPrice();
}
