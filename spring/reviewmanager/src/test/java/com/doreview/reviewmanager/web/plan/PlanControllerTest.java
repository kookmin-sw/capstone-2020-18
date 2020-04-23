package com.doreview.reviewmanager.web.plan;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PlanController.class)
@ActiveProfiles("test")
class PlanControllerTest {

    @MockBean
    private PlanController planController;

    @Autowired
    private MockMvc mockMvc;    //webMvcTest와 autowired로 인해 이 변수를 초기화 해줌.

    @Test
    void toDoList() throws Exception {
        given(planController.toDoList()).willReturn("hi");
        mockMvc.perform(
                get("/api/plans")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hi")));
    }
}
