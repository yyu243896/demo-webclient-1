package com.example.demo.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceUtils {


    public static final String ORG_MARIADB_JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mariadb://localhost:3306/mydream77?serverTimezone=UTC&characterEncoding=UTF-8&allowMultiQueries=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    public static DataSource getDatasource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(ORG_MARIADB_JDBC_DRIVER);
        hikariConfig.setJdbcUrl(JDBC_URL);
        hikariConfig.setUsername(USERNAME);
        hikariConfig.setPassword(PASSWORD);

        return new HikariDataSource(hikariConfig);
    }
}
