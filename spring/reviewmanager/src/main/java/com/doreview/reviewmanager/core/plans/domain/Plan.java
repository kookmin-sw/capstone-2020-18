package com.doreview.reviewmanager.core.plans.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String content;

    @Getter
    private final LocalDateTime createdDate = LocalDateTime.now();

    @Getter
    private LocalDateTime lastModifiedDate = createdDate;

    @Getter
    private boolean deleted;

    public void update(Plan plan) {
        content = plan.getContent();
        lastModifiedDate = LocalDateTime.now();
    }


    public void delete() {
        this.deleted = true;
    }
}
