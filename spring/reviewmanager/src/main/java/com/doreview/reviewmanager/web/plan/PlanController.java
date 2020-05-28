package com.doreview.reviewmanager.web.plan;

import com.doreview.reviewmanager.Dto.PlanDto;
import com.doreview.reviewmanager.core.plans.application.PlanService;
import com.doreview.reviewmanager.core.plans.domain.Plan;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    @Autowired
    PlanService planService;
    @Autowired
    Mapper mapper;

    @GetMapping("todolist")
    public String todayPlans() {
        return "{\"id\" : \"1\" ,\"content\":\"아침식사\", \"deleted\":false, \"createdDate\":\"2019-12-14T06:34:20\",\"lastModifiedDate\":\"2019-12-14T06:34:20\"}";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PlanDto planDto) {
        Plan plan = mapper.map(planDto, Plan.class);
        planService.addPlan(plan);
    }

    @PatchMapping("{id}")
    public void updatePlan(@PathVariable Long id, @RequestBody PlanDto planDto) {
        Plan plan = mapper.map(planDto, Plan.class);
        planService.updatePlan(id, plan);
    }

    @DeleteMapping("{id}")
    public void deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
    }
}
