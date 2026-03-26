package study.spring.solid.part3.purchase.adapter.in.web.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {
    private UUID id;
    private BigDecimal price;
    private String name;
    private String vendorName;
    private BigDecimal amount;
}
