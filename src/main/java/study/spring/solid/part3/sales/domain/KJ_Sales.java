package study.spring.solid.part3.sales.domain;

import lombok.*;
import study.spring.solid.part3.sap.KJ_SapDataProvider;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
public class KJ_Sales implements KJ_SapDataProvider {

    private final UUID id;
    private final BigDecimal price;
    private final String name;
    private final String description;
    private final BigDecimal amount;

    public KJ_Sales processId(UUID id) {
        return this.toBuilder()
                .id(id)
                .build();
    }
}
