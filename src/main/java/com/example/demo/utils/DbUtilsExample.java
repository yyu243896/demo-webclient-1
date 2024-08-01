package com.example.demo.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbUtilsExample {

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(
                DataSourceUtils.JDBC_URL,
                DataSourceUtils.USERNAME,
                DataSourceUtils.PASSWORD
        );


        QueryRunner runner = new QueryRunner();
        List<Map<String, Object>> resultmap = runner.query(conn, "select * from TB_BRD", new MapListHandler());


//        QueryRunner runner = new QueryRunner(DataSourceUtils.getDatasource());
//        List<Map<String, Object>> resultmap = runner.query("select * from TB_BRD", new MapListHandler());

        for (Map<String, Object> map : resultmap) {
            System.out.println("map = " + map);
        }

    }
}
