package study.spring.solid.part3.sales.domain;

import lombok.*;
import study.spring.solid.part3.sap.domain.JHG_SapStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Sales implements JHG_SapStatus {

    private final UUID id;
    private final BigDecimal price;
    private final String name;
    private final String description;
    private final BigDecimal amount;

    public Sales processId(UUID id) {
        return this.toBuilder()
                .id(id)
                .build();
    }
}
