package study.spring.solid.part2.adapter.out;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.spring.solid.part2.application.prot.out.SavePort;
import study.spring.solid.part2.domain.Data;

@Slf4j
@Component
public class SaveAdapter implements SavePort {

    /**
     * 트랜잭션 내에서 데이터 저장
     * 저장 실패 시 상위 트랜잭션도 롤백됨
     */
    @Override
    public void save(Data data) {
        log.info("트랜잭션 내 데이터 저장 시작 - ID: {}, 내용: {}", data.getId(), data.getContent());
        // TODO: 실제 저장 로직 (메모리, 파일 등)
        // 저장 실패 시 예외 발생하여 트랜잭션 롤백
        log.info("트랜잭션 내 데이터 저장 완료 - ID: {}", data.getId());
    }
}
