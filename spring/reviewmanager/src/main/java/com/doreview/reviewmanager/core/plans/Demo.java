package com.doreview.reviewmanager.core.plans;

import com.doreview.reviewmanager.core.plans.domain.Plan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//1회는 바로 복습에 올라가야함.
//2회는 24시간지나면 올라가야함.
//3회는 7일 지나면 올라가야함.
//4회는 15일 지나면 올라가야함.
//5회는 30일 지나면 올라가야함.

public class Demo {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static List<Plan> planData() {
        return List.of(
                Plan.builder().content("1").studycount(1).lateststudydate(LocalDateTime.parse("2020-05-01 13:43:27.000", formatter)).build(),
                Plan.builder().content("2").studycount(2).lateststudydate(LocalDateTime.parse("2020-04-29 13:43:27.000", formatter)).build(),
                Plan.builder().content("3").studycount(3).lateststudydate(LocalDateTime.parse("2020-04-22 13:43:27.000", formatter)).build(),
                Plan.builder().content("3").studycount(3).lateststudydate(LocalDateTime.parse("2020-05-01 13:43:27.000", formatter)).build(),
                Plan.builder().content("3").studycount(3).lateststudydate(LocalDateTime.parse("2020-04-29 13:43:27.000", formatter)).build(),
                Plan.builder().content("4").studycount(4).lateststudydate(LocalDateTime.parse("2020-04-14 13:43:27.000", formatter)).build(),
                Plan.builder().content("4").studycount(4).lateststudydate(LocalDateTime.parse("2020-04-27 13:43:27.000", formatter)).build(),
                Plan.builder().content("5").studycount(5).lateststudydate(LocalDateTime.parse("2020-02-30 13:43:27.000", formatter)).build()
        );
    }

    public static List<Plan> reviewData() {
        return List.of(
                Plan.builder().content("1").studycount(1).lateststudydate(LocalDateTime.parse("2020-05-01 13:43:27.000", formatter)).build(),
                Plan.builder().content("2").studycount(2).lateststudydate(LocalDateTime.parse("2020-04-29 13:43:27.000", formatter)).build(),
                Plan.builder().content("3").studycount(3).lateststudydate(LocalDateTime.parse("2020-04-22 13:43:27.000", formatter)).build(),
                Plan.builder().content("4").studycount(4).lateststudydate(LocalDateTime.parse("2020-04-14 13:43:27.000", formatter)).build(),
                Plan.builder().content("5").studycount(5).lateststudydate(LocalDateTime.parse("2020-03-30 13:43:27.000", formatter)).build()
        );
    }
}
