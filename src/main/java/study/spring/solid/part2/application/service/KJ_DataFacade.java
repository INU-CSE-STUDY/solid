package study.spring.solid.part2.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part2.application.prot.in.DataUseCase;
import study.spring.solid.part2.domain.Data;

import java.util.concurrent.TimeoutException;

@Slf4j
@Service
@Profile("KJ")
@RequiredArgsConstructor
public class KJ_DataFacade implements DataUseCase {

    private static final long TRANSACTION_TIMEOUT_SECONDS = 3L;

    private final KJ_DataProcessService dataProcessService;
    private final KJ_DataSaveService dataSaveService;

    @Override
    public Data processData(String content) {
        log.info("트랜잭션 시작 - 내용: {}", content);

        try {
            Data result = dataProcessService.processData(content);
            dataSaveService.save(result);

            return result;
        } catch (Exception e) {
            log.error("트랜잭션 롤백", e);
            if (e.getCause() instanceof TimeoutException) {
                throw new RuntimeException("트랜잭션 시간 제한 초과: " + TRANSACTION_TIMEOUT_SECONDS + "초", e);
            }
            throw new RuntimeException("데이터 처리 실패", e);
        }
    }
}
