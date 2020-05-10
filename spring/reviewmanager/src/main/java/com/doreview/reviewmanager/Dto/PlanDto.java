package com.doreview.reviewmanager.Dto;

import com.github.dozermapper.core.Mapping;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanDto {

    @Mapping("id")
    private Long id;

    @NotBlank
    @Mapping("content")
    private String content;

    @NotBlank
    @Mapping("deleted")
    private boolean deleted;

    @NotBlank
    @Mapping("createdDate")
    private  LocalDateTime createdDate;

    @NotBlank
    @Mapping("lastModifiedDate")
    private LocalDateTime lastModifiedDate;

}
