package com.doreview.reviewmanager;

import com.doreview.reviewmanager.core.plans.domain.Plan;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dao {

    private Connection conn;   //데이터베이스에 접근하기 위한 객체
    private PreparedStatement pstmt;
    ResultSet rs;
    Statement stmt = null;
    @SneakyThrows
    public Dao() {
        String dbURL="jdbc:mysql://database-2.cvfikrglnrdr.ap-northeast-2.rds.amazonaws.com:3306/planreview?serverTimezone=UTC&characterEncoding=UTF-8";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
    }

    public int insertPlan(String plan) throws Exception {
        String SQL = "INSERT INTO master(regdate) values(now())";
        pstmt = conn.prepareStatement(SQL);
        pstmt.executeUpdate();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT LAST_INSERT_ID();");
        rs.next();
        int id = rs.getInt("LAST_INSERT_ID()");
        System.out.println(id);
        String SQL2 = "INSERT INTO plan(plan_id,content) values(?,?)";
        pstmt = conn.prepareStatement(SQL2);
        pstmt.setInt(1,id);
        pstmt.setString(2,plan);
        pstmt.executeUpdate();
        return 1;
    }
    public boolean existStudyHistory(Long plan_id) throws Exception{
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * from lateststudy where plan_id ="+plan_id);
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }

    public void insertStudy(Long plan_id) throws Exception{
        if (!existStudyHistory(plan_id)) {
            String SQL = "INSERT INTO lateststudy(plan_id,regdate) values(?,now())";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setLong(1,plan_id);
            pstmt.executeUpdate();
        }else{
            String SQL = "update lateststudy set regdate = now() where plan_id="+plan_id;
            pstmt = conn.prepareStatement(SQL);
            pstmt.executeUpdate();
            SQL = "INSERT INTO studyhistory(plan_id, regdate) values(?,now())";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setLong(1,plan_id);
            pstmt.executeUpdate();
        }
    }

    public void updatePlan(Long plan_id, String content) throws Exception {
        String SQL = "update plan set content = ?, lastmodifieddate = now() where plan_id="+plan_id;
        pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1,content);
        pstmt.executeUpdate();
    }

    public void deletePlan(Long plan_id) throws Exception {
        String SQL = "update plan set isdeleted = true where plan_id="+plan_id;
        System.out.println(SQL);
        pstmt = conn.prepareStatement(SQL);
        pstmt.executeUpdate();
    }

    public List<Plan> getTodayPlans() throws Exception{
        String SQL = "Select a.plan_id,a.content,a.lastmodifieddate,b.regdate as lateststudydate" +
                " from plan as a left join lateststudy as b on a.plan_id = b.plan_id " +
                "where b.regdate is null and isdeleted = 0 ";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(SQL);
        List<Plan> list = new ArrayList<>();
        while(rs.next()){
           Plan plan = Plan.builder().plan_id(rs.getLong("plan_id"))
                    .content(rs.getString("content"))
                    .lastmodifieddate(LocalDateTime.parse(rs.getString("lastmodifieddate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
           list.add(plan);
        }
        return list;

    }

    public Optional<Plan> getPlanById(Long l) throws SQLException {
        String SQL = "Select * from plan where plan_id="+l;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(SQL);
        if(rs.next()){
            return Optional.of(Plan.builder()
                    .plan_id(rs.getLong("plan_id"))
                    .content(rs.getString("content"))
                    .build());
        }else{
            return Optional.empty();
        }
    }

    public List<Plan> getCompletedPlanForToday() throws SQLException {
        String SQL = "Select a.plan_id,a.content,a.lastmodifieddate,b.regdate as lateststudydate, ifnull(c.count,0) as studycount from plan as a left join lateststudy as b on a.plan_id = b.plan_id left join (select count(*) as count ,plan_id from (select * from studyhistory  union select * from lateststudy) as t group by plan_id) as c on a.plan_id=c.plan_id where isdeleted = 0 and c.count <= 6 and c.count>=2 and DATE(b.regdate)=DATE(now())";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(SQL);
        List<Plan> list = new ArrayList();
        while(rs.next()) {
            Plan plan = Plan.builder().plan_id(rs.getLong("plan_id"))
                    .content(rs.getString("content"))
                    .lastmodifieddate(LocalDateTime.parse(rs.getString("lastmodifieddate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .lateststudydate(LocalDateTime.parse(rs.getString("lateststudydate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .studycount(rs.getInt("studycount"))
                    .build();
            list.add(plan);
        }
        return list;
    }

    public List<Plan> BeingManagedPlans() throws Exception{
        String SQL = "Select a.plan_id,a.content,a.lastmodifieddate,b.regdate as lateststudydate, ifnull(c.count,0) as studycount from plan as a left join lateststudy as b on a.plan_id = b.plan_id left join (select count(*) as count ,plan_id from (select * from studyhistory  union select * from lateststudy) as t group by plan_id) as c on a.plan_id=c.plan_id where isdeleted = 0 and c.count <= 5 and c.count>=1;";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(SQL);
        List<Plan> list = new ArrayList();
        while(rs.next()) {
            Plan plan = Plan.builder().plan_id(rs.getLong("plan_id"))
                    .content(rs.getString("content"))
                    .lastmodifieddate(LocalDateTime.parse(rs.getString("lastmodifieddate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .lateststudydate(LocalDateTime.parse(rs.getString("lateststudydate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .studycount(rs.getInt("studycount"))
                    .build();
            list.add(plan);
        }
        return list;
    }
}
