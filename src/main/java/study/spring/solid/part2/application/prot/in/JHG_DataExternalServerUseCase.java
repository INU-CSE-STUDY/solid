package study.spring.solid.part2.application.prot.in;

public interface JHG_DataExternalServerUseCase {

    /**
     * 외부 API 호출 후 해당 content의 ID를 반환
     * @param content content
     * @return ID
     */
    String call(String content);
}
