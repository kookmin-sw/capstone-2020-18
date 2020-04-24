package com.doreview.reviewmanager.web.plan;

import com.doreview.reviewmanager.core.plans.application.PlanService;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reviews")
public class ReviewController {
    @Autowired
    PlanService planService;
    @Autowired
    Mapper mapper;

}
