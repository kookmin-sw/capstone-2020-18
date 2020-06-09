package com.doreview.reviewmanager.web.plan;

import com.doreview.reviewmanager.Dto.PlanDto;
import com.doreview.reviewmanager.core.plans.application.PlanService;
import com.doreview.reviewmanager.core.plans.domain.Plan;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    @Autowired
    PlanService planService;
    @Autowired
    Mapper mapper;

    @GetMapping("todolist")
    public List<Plan> todayPlans() throws Exception {
        return planService.getToDoList();
    }

    @GetMapping("completedlist")
    public List<Plan> completedList() throws Exception {
        return planService.getCompletedPlans();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PlanDto planDto) {
        Plan plan = mapper.map(planDto, Plan.class);
        try {
            planService.addPlan(plan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PatchMapping("/{id}")
    public void updatePlan(@PathVariable Long id, @RequestBody PlanDto planDto) throws Exception {
        Plan plan = mapper.map(planDto, Plan.class);
        System.out.println(id);
        planService.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) throws Exception {
        planService.deletePlan(id);
    }

    @PostMapping("/complete/{id}")
    public void completePlan(@PathVariable Long id) throws Exception {
        planService.completePlan(id);
    }

}
