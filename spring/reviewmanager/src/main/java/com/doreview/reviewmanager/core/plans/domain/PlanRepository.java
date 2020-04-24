package com.doreview.reviewmanager.core.plans.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    Plan save(Plan plan);
    Optional<Plan> findById(Long l);
    List<Plan> findTodayPlans(); //어떤 기준으로 가져올 것인지에 대해서 이건 jpa를 어떻게 사용할지 찾아봐야한다.
}
