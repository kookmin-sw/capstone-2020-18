package com.doreview.reviewmanager.core.plans.domain;

import com.doreview.reviewmanager.core.plans.Demo;
import com.doreview.reviewmanager.core.plans.application.DefaultScheduler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SchedulerTest {

    DefaultScheduler scheduler;


    @BeforeEach
    void setUp() {
        scheduler = new DefaultScheduler();
    }

    @Test
    void filterTodayReview() {
        assertThat(scheduler.filterTodayReview(Demo.planData())).isEqualTo(Demo.reviewData());
    }
}