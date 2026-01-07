package study.spring.solid.part2.application.prot.in;

import study.spring.solid.part2.domain.Data;

public interface DataUseCase {
    Data processData(String content);
}
