package com.doreview.reviewmanager.web.plan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @GetMapping
    public String toDoList() {
        return "hi";
    }
}
