package com.doreview.reviewmanager.core.plans.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PlanRepository {
    void insert(String plan) throws Exception;
    Optional<Plan> findById(Long l) throws SQLException;
    List<Plan> findTodayPlans() throws Exception;
    void delete(Long l) throws Exception;
    List<Plan> getBeingManagedPlan() throws Exception;
    void update(Long id, String content) throws Exception;

    void completePlan(Long id) throws Exception;

    List<Plan> getCompletedPlans() throws SQLException;
}
