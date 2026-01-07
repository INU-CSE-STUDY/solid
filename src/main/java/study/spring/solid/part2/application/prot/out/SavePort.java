package study.spring.solid.part2.application.prot.out;

import study.spring.solid.part2.domain.Data;

public interface SavePort {
    void save(Data data);
}
