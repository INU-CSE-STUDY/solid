package study.spring.solid.part2.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import study.spring.solid.part2.application.prot.out.SavePort;
import study.spring.solid.part2.domain.Data;

@Slf4j
@Service
@Profile("KJ")
@RequiredArgsConstructor
public class KJ_DataSaveService {

    private final SavePort savePort;

    // @Transactional 나중에 이게 들어가겠지..
    public void save(Data data) {
        savePort.save(data);
    }
}
