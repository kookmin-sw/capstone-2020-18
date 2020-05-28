package com.doreview.reviewmanager.core.plans.application;

import com.doreview.reviewmanager.core.plans.domain.Plan;
import com.doreview.reviewmanager.core.plans.domain.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class PlanService {

    private final PlanRepository planRepository;


    public void addPlan(Plan plan) {

        planRepository.save(plan);
    }


    public Plan updatePlan(long id, Plan planInfo) {

        Plan plan = planRepository.findById(id).get();

        plan.update(planInfo);

        return plan;
    }

    public Plan deletePlan(long id) {
        Plan plan = planRepository.findById(id).get();

        plan.delete();

        return plan;
    }

    public List<Plan> getToDoList() {
        List<Plan> toDoList = planRepository.findTodayPlans();

        return toDoList;
    }
}
