package study.spring.solid.part1.adapter.in.web.dto;

import lombok.NoArgsConstructor;
import study.spring.solid.part1.doamin.CalculateOperation;

@NoArgsConstructor
public class CalculateDto {

    public CalculateOperation operation;
    public long operator1;
    public long operator2;
}