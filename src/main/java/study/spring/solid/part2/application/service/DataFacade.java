package study.spring.solid.part2.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.spring.solid.part2.application.prot.in.DataUseCase;
import study.spring.solid.part2.application.prot.out.ExternalApiPort;
import study.spring.solid.part2.application.prot.out.SavePort;
import study.spring.solid.part2.domain.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataFacade implements DataUseCase {

    private static final long TRANSACTION_TIMEOUT_SECONDS = 3L;

    private final ExternalApiPort externalApiPort;
    private final SavePort savePort;

    @Override
    public Data processData(String content) {
        log.info("트랜잭션 시작 - 내용: {}", content);

        try {
            return CompletableFuture
                    .supplyAsync(() -> {
                        String id = externalApiPort.callExternalApi(content);
                        Data result = new Data(id, content);
                        savePort.save(result);
                        return result;
                    })
                    .orTimeout(TRANSACTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .join();
        } catch (Exception e) {
            log.error("트랜잭션 롤백", e);
            if (e.getCause() instanceof TimeoutException) {
                throw new RuntimeException("트랜잭션 시간 제한 초과: " + TRANSACTION_TIMEOUT_SECONDS + "초", e);
            }
            throw new RuntimeException("데이터 처리 실패", e);
        }
    }
}
