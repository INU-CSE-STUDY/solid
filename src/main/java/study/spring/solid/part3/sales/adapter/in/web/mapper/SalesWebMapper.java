package study.spring.solid.part3.sales.adapter.in.web.mapper;

import org.springframework.stereotype.Component;
import study.spring.solid.part3.sales.adapter.in.web.dto.CreateSalesDto;
import study.spring.solid.part3.sales.adapter.in.web.dto.SalesDto;
import study.spring.solid.part3.sales.application.port.in.CreateSalesCommand;
import study.spring.solid.part3.sales.domain.KJ_Sales;

@Component
public class SalesWebMapper {

    public CreateSalesCommand toCommand(CreateSalesDto dto) {
        return new CreateSalesCommand(
                dto.getPrice(),
                dto.getName(),
                dto.getDescription(),
                dto.getAmount()
        );
    }

    public SalesDto toDto(KJ_Sales sales) {
        return new SalesDto(
                sales.getId(),
                sales.getPrice(),
                sales.getName(),
                sales.getDescription(),
                sales.getAmount()
        );
    }
}
