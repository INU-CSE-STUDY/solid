package study.spring.solid.part2.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part2.application.prot.in.JHG_DataCommandUseCase;
import study.spring.solid.part2.application.prot.in.JHG_DataExternalServerUseCase;
import study.spring.solid.part2.application.prot.out.ExternalApiPort;
import study.spring.solid.part2.application.prot.out.SavePort;
import study.spring.solid.part2.domain.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Profile("JHG")
@Service
@RequiredArgsConstructor
public class JHG_DataService implements JHG_DataCommandUseCase, JHG_DataExternalServerUseCase {

    private final SavePort savePort;
    private final ExternalApiPort externalPort;

    private static final long TRANSACTION_TIMEOUT_SECONDS = 3L;

    @Override
    public void save(Data data) {
        try {
            CompletableFuture
                    .supplyAsync(() -> {
                        savePort.save(data);
                        return data;
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

    @Override
    public String call(String content) {
        return externalPort.callExternalApi(content);
    }
}
