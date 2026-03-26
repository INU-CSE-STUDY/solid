package study.spring.solid.part3.purchase.adapter.in.web.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePurchaseDto {

    private BigDecimal price;
    private String name;
    private String vendorName;
    private BigDecimal amount;
}
