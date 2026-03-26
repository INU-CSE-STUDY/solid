package study.spring.solid.part3.sales.adapter.in.web.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSalesDto {

    private BigDecimal price;
    private String name;
    private String description;
    private BigDecimal amount;
}
