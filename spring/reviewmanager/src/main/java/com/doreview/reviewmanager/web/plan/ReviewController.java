package com.doreview.reviewmanager.web.plan;

import com.doreview.reviewmanager.core.plans.application.PlanService;
import com.doreview.reviewmanager.core.plans.domain.Plan;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    PlanService planService;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<Plan> completedList() throws Exception {
        return planService.getReviewList();
    }

}
