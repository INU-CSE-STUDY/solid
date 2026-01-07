package study.spring.solid.part2.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.spring.solid.part2.adapter.in.web.dto.DataRequestDto;
import study.spring.solid.part2.adapter.in.web.dto.DataResponseDto;
import study.spring.solid.part2.application.prot.in.DataUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DataController {

    private final DataUseCase dataUseCase;

    @PostMapping("/data")
    public DataResponseDto processData(@RequestBody DataRequestDto request) {
        return DataResponseDto.from(
                dataUseCase.processData(request.content)
        );
    }
}
