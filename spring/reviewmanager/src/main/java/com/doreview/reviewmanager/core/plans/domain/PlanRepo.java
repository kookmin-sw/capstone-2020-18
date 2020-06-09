package com.doreview.reviewmanager.core.plans.domain;

import com.doreview.reviewmanager.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PlanRepo implements PlanRepository {
    Dao dao;
    public PlanRepo(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void insert(String plan) throws Exception {
        dao.insertPlan(plan);
    }

    @Override
    public Optional<Plan> findById(Long l) throws SQLException {
        return dao.getPlanById(l);
    }

    @Override
    public List<Plan> findTodayPlans() throws Exception {
        return dao.getTodayPlans();
    }

    @Override
    public List<Plan> getBeingManagedPlan() throws Exception {
        return dao.BeingManagedPlans();
    }

    @Override
    public void delete(Long l) throws Exception {
        dao.deletePlan(l);
    }

    @Override
    public void update(Long id, String content) throws Exception {
        dao.updatePlan(id,content);
    }

    @Override
    public void completePlan(Long id) throws Exception {
        dao.insertStudy(id);
    }

    @Override
    public List<Plan> getCompletedPlans() throws SQLException {
        return dao.getCompletedPlanForToday();
    }
}
