package com.doreview.reviewmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DaoTest {
    Dao dao;

    @BeforeEach
    void setUp() {
        dao = new Dao();
    }

    @Test
    void insert() throws Exception {
        dao.insertStudy(14L);
//        dao.updatePlan(14,"안녕하세요");
//        dao.deletePlan(14);
    }
}