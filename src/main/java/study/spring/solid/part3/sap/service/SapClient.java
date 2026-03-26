package study.spring.solid.part3.sap.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.spring.solid.part3.sap.dto.SapSendDto;

import java.util.UUID;

@Slf4j
@Component
public class SapClient {

    public UUID getId(SapSendDto dto) {

        log.info("SapClient getId {}", dto);

        return UUID.randomUUID();
    }
}
