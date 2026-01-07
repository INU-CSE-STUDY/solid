package study.spring.solid.part2.adapter.out;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.spring.solid.part2.application.prot.out.ExternalApiPort;

@Slf4j
@Component
public class ExternalApiAdapter implements ExternalApiPort {

    @Override
    public String callExternalApi(String content) {
        log.info("외부 API 호출 시작 - 내용: {}", content);
        try {
            Thread.sleep(3500); // 3.5초 대기 (3초 제한 초과)
            log.info("외부 API 호출 완료");
            return "External API Response: " + content;
        } catch (InterruptedException e) {
            log.error("외부 API 호출 중단", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("외부 API 호출 실패", e);
        }
    }
}
