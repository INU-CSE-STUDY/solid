package study.spring.solid.part3.sales.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part3.sales.application.port.in.CreateSalesCommand;
import study.spring.solid.part3.sales.application.port.in.SalesUseCase;
import study.spring.solid.part3.sales.application.port.out.SalesSapPort;
import study.spring.solid.part3.sales.domain.KJ_Sales;

import java.util.UUID;

@Service
@Profile("KJ")
@RequiredArgsConstructor
public class KJ_SalesService implements SalesUseCase {

    private final SalesSapPort salesSapPort;

    @Override
    public KJ_Sales processData(CreateSalesCommand command) {
        KJ_Sales sales = command.of();

        UUID id = salesSapPort.save(sales);

        return sales.processId(id);
    }
}
