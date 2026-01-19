package study.spring.solid.part2.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part2.application.prot.in.DataUseCase;
import study.spring.solid.part2.application.prot.in.JHG_DataCommandUseCase;
import study.spring.solid.part2.application.prot.in.JHG_DataExternalServerUseCase;
import study.spring.solid.part2.domain.Data;

@Slf4j
@Service
@Profile("JHG")
@RequiredArgsConstructor
public class JHG_DataFacadeService implements DataUseCase {

    private final JHG_DataExternalServerUseCase serverUseCase;
    private final JHG_DataCommandUseCase commandUseCase;

    /**
     * 외부 API를 호출 후 그것을 활용해 데이터를 저장
     * @param content content
     * @return 저장된 데이터
     */
    @Override
    public Data processData(String content) {

        String id = serverUseCase.call(content);

        Data data = new Data(id, content);

        commandUseCase.save(data);

        return data;
    }
}
