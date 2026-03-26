package study.spring.solid.part3.sap.dto;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class SapSendDto {
    private BigDecimal amount;
    private BigDecimal price;
}
