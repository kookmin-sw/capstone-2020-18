package com.doreview.reviewmanager.Dto;

import com.github.dozermapper.core.Mapping;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanDto{

    @Mapping("plan_id")
    private Long id;

    @NotBlank
    @Mapping("content")
    private String content;

    @Mapping("isdeleted")
    private boolean isdeleted;

    @Mapping("regdate")
    private  LocalDateTime regdate;

    @Mapping("lastmodifieddate")
    private LocalDateTime lastmodifieddate;

    @Mapping("studycount")
    private int studyCount;

    @Mapping("lateststudydate")
    private  LocalDateTime lateststudydate;
}
