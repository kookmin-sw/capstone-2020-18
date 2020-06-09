package com.doreview.reviewmanager.core.plans.application;

import com.doreview.reviewmanager.core.plans.Demo;
import com.doreview.reviewmanager.core.plans.domain.Plan;
import com.doreview.reviewmanager.core.plans.domain.PlanRepository;
import com.doreview.reviewmanager.core.plans.domain.Scheduler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class PlanServiceTest {
    PlanService planService;
    @Mock
    PlanRepository planRepository;
    @Mock
    Scheduler scheduler;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        planService = new PlanService(planRepository, scheduler);
    }

//    @Test
//    public void getToDoList() {
//        given(planRepository.findTodayPlans())
//                .willReturn(List.of(
//                        Plan.builder().content("아침 식사")
//                                .lastModifiedDate(LocalDateTime.parse("2019-12-14T06:34:20"))
//                                .studyTimes(0)
//                                .lastStudyDate(null)
//                                .build()
//                ));
//
//        List<Plan> toDolist = planService.getToDoList();
//
//        verify(planRepository).findTodayPlans();
//
//        assertThat(toDolist.stream().allMatch(v -> v.getStudyTimes() == 0)).isTrue();
//    }
//
//    @Test
//    public void getReviewList() {
//        given(planRepository.getBeingManagedPlan()).willReturn(Demo.planData());
//        given(scheduler.filterTodayReview(Demo.planData())).willReturn(Demo.reviewData());
//
//        assertThat(planService.getReviewList()).isEqualTo(Demo.reviewData());
//
//        verify(planRepository).getBeingManagedPlan();
//
//        verify(scheduler).filterTodayReview(Demo.planData());
//    }
//
//    @Test
//    public void getCompletedList() {
//
////        assertThat(planService)
//    }



    @Test
    public void addPlan() throws Exception {
        Plan plan = Plan.builder().content("아침식사").build();
        planService.addPlan(plan);

        verify(planRepository).insert(plan.getContent());
    }


//    @Test
//    public void update() {
//        given(planRepository.findById(1L))
//                .willReturn(Optional.of(
//                        Plan.builder().content("아침 식사").build()
//                ));
//
//        Plan plan = Plan.builder().content("점심 식사").build();
//        Plan updatedPlan = planService.updatePlan(1L,plan);
//
//        verify(planRepository).findById(1L);
//        assertThat(updatedPlan.getContent()).isEqualTo("점심 식사");
//    }
//
//    @Test
//    public void delete() {
//        given(planRepository.findById(1L))
//                .willReturn(Optional.of(
//                        Plan.builder().content("아침 식사").build()
//                ));
//
//        Plan plan = planService.deletePlan(1L);
//
//        verify(planRepository).findById(1L);
//        assertThat(plan.isDeleted()).isTrue();
//    }



}