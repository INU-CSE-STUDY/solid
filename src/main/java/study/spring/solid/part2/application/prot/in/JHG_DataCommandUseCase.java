package study.spring.solid.part2.application.prot.in;

import study.spring.solid.part2.domain.Data;

public interface JHG_DataCommandUseCase {

    /**
     * 저장
     * @param data 저장할 데이터
     */
    void save(Data data);
}
