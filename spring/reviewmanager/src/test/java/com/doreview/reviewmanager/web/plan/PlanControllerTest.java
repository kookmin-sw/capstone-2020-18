package com.doreview.reviewmanager.web.plan;

import com.doreview.reviewmanager.core.plans.application.PlanService;
import com.doreview.reviewmanager.core.plans.domain.Plan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PlanController.class)
@ActiveProfiles("test")
class PlanControllerTest {

    @MockBean
    private PlanService planService;

    @Autowired
    private MockMvc mockMvc;    //webMvcTest와 autowired로 인해 이 변수를 초기화 해줌.


    @Test
    public void createPlan() throws Exception {
        mockMvc.perform(
                post("/api/plans")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"content\":\"아침식사\"}")
        ).andExpect(status().isCreated());

        verify(planService).addPlan(any(Plan.class));
    }

    @Test
    public void toDoList() throws Exception {
        mockMvc.perform(
                get("/api/plans/todolist")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"id\" : \"1\" ,\"content\":\"아침식사\", \"deleted\":false, \"createdDate\":\"2019-12-14T06:34:20\",\"lastModifiedDate\":\"2019-12-14T06:34:20\"}")
        ).andExpect(status().isOk());

    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(
                patch("/api/plans/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"content\":\"아침식사\"}")
        ).andExpect(status().isOk());
        verify(planService).updatePlan(eq(1L),any(Plan.class));
    }

    @Test
    public void destroy() throws Exception {
        mockMvc.perform(
                delete("/api/plans/1")
        )
                .andExpect(status().isOk());
        verify(planService).deletePlan((long)1);
    }

}
