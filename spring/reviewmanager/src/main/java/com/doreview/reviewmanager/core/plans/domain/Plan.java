package com.doreview.reviewmanager.core.plans.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    @Id
    @Getter
    private Long plan_id;

    @Getter
    private String content;

    @Getter
    private final LocalDateTime regdate = LocalDateTime.now();

    @Getter
    private LocalDateTime lastmodifieddate;

    @Getter
    private LocalDateTime lateststudydate;

    @Getter
    private boolean isdeleted;

    @Getter
    private int studycount;

    public void update(String content) {
        this.content = content;
        this.lastmodifieddate = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        return Objects.hash(plan_id, content, regdate, lastmodifieddate, lateststudydate, isdeleted, studycount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Plan plan = (Plan) obj;
        if (this.plan_id == plan.plan_id) {
            return true;
        }
        return false;
    }

    public void delete() {
        this.isdeleted = true;
    }
}
