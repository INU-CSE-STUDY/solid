package study.spring.solid.part2.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.spring.solid.part2.domain.Data;

@Getter
@AllArgsConstructor
public class DataResponseDto {
    private String id;
    private String content;

    public static DataResponseDto from(Data data) {
        return new DataResponseDto(
                data.getId(),
                data.getContent()
        );
    }
}
