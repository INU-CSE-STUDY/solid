package study.spring.solid.part3.purchase.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import study.spring.solid.part3.sap.SapDataProvider;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Purchase implements SapDataProvider {

    private final UUID id;
    private final BigDecimal price;
    private final String name;
    private final String vendorName;
    private final BigDecimal amount;

    public Purchase processId(UUID id) {
        return this.toBuilder()
                .id(id)
                .build();
    }
}
