package com.doreview.reviewmanager.core.plans.application;

import com.doreview.reviewmanager.core.plans.domain.Plan;
import com.doreview.reviewmanager.core.plans.domain.Scheduler;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultScheduler implements Scheduler {
    @Override
    public List<Plan> filterTodayReview(List<Plan> plans) {
        return plans.stream().filter(v -> {
            //1회는 바로 복습에 올라가야함.
            //2회는 24시간지나면 올라가야함.
            //3회는 7일 지나면 올라가야함.
            //4회는 15일 지나면 올라가야함.
            //5회는 30일 지나면 올라가야함.
            switch (v.getStudycount()) {

                case 1 : return true;
                case 2 :
                    if (Period.between(v.getLateststudydate().toLocalDate(), LocalDate.now()).getDays() >= 1) {
                        return true;
                    }
                case 3 :
                    if (Period.between(v.getLateststudydate().toLocalDate(), LocalDate.now()).getDays() >= 7) {
                        return true;
                    }
                case 4 :
                    if (Period.between(v.getLateststudydate().toLocalDate(), LocalDate.now()).getDays() >= 15) {
                        return true;
                    }
                case 5 :
                    if (Period.between(v.getLateststudydate().toLocalDate(), LocalDate.now()).getMonths() >= 1) {
                        return true;
                    }
                default:
                    return false;
            }
        }).collect(Collectors.toList());

    }
}
