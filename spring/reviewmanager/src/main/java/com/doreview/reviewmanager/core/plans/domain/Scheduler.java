package com.doreview.reviewmanager.core.plans.domain;

import java.util.List;

public interface Scheduler {
    List<Plan> filterTodayReview(List<Plan> plans);
}
