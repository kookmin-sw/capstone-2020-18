package com.doreview.reviewmanager;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://database-2.cvfikrglnrdr.ap-northeast-2.rds.amazonaws.com:3306/planreview?serverTimezone=UTC&characterEncoding=UTF-8";

    private static final String USER ="admin";

    private static final String PW = "qwer1234";



    @Test

    public void testConnection() throws Exception{

        Class.forName(DRIVER);

        try (Connection con = DriverManager.getConnection(URL, USER, PW))	{

            System.out.println(con);



        }catch(Exception e){

            System.err.println(e);

        }

    }

}
