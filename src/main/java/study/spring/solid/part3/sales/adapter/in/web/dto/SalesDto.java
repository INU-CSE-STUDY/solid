package study.spring.solid.part3.sales.adapter.in.web.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDto {
    private UUID id;
    private BigDecimal price;
    private String name;
    private String description;
    private BigDecimal amount;
}
