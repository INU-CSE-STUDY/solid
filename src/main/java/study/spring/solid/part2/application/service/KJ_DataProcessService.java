package study.spring.solid.part2.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part2.application.prot.out.ExternalApiPort;
import study.spring.solid.part2.domain.Data;

@Slf4j
@Service
@Profile("KJ")
@RequiredArgsConstructor
public class KJ_DataProcessService {

    private final ExternalApiPort externalApiPort;

    String getContentId(String content) {
        // 사용처가 processData밖에 없어서 private으로 두고 싶은데.. 테스트 등의 목적으로 default로 두는 건 실무 관점에서 어떤지 리뷰해주세용.
        // (ex) 외부 API 호출하는 부분이 복잡해져서 정밀한 테스트가 필요할 때 private은 테스트가 안됨(그렇다고 public으로 돌리기는 그렇잖아)
        //      이 경우에 default로 두면 테스트할 때 유용하니까..?!
        return externalApiPort.callExternalApi(content);
    }

    public Data processData(String content) {

        String id = this.getContentId(content);

        // 나중에 데이터 가공 로직이 복잡해질 경우를 대비해서 분리
        return new Data(id, content);
    }
}
