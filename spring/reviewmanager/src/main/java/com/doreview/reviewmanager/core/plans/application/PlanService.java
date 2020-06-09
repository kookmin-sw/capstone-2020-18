package com.doreview.reviewmanager.core.plans.application;

import com.doreview.reviewmanager.core.plans.domain.Plan;
import com.doreview.reviewmanager.core.plans.domain.PlanRepository;
import com.doreview.reviewmanager.core.plans.domain.Scheduler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class PlanService {

    private PlanRepository planRepository;

    private Scheduler scheduler;

    public void addPlan(Plan plan) throws Exception{

        planRepository.insert(plan.getContent());
    }


    public Plan updatePlan(long id, Plan plan_) throws Exception {

        Plan plan = planRepository.findById(id).get();
        plan.update(plan_.getContent());
        planRepository.update(id,plan_.getContent());

        return plan;
    }

    public void deletePlan(long id) throws Exception {
        planRepository.delete(id);
    }

    public List<Plan> getToDoList() throws Exception{
        List<Plan> toDoList = planRepository.findTodayPlans();

        return toDoList;
    }

    public List<Plan> getReviewList() throws Exception {
        List<Plan> reviewList = planRepository.getBeingManagedPlan();

        return scheduler.filterTodayReview(reviewList);
    }


    public void completePlan(Long id) throws Exception {
        planRepository.completePlan(id);
    }

    public List<Plan> getCompletedPlans()throws Exception {
       return planRepository.getCompletedPlans();
    }
}
