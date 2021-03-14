package com.vytrack.runners;

import java.sql.*;

public class Example {
    public static void main(String[] args) throws SQLException {
        String dbUrl= "jdbc:mysql://3.87.155.124:3306/bitnami_orocrm";
        String dbUserName= "qa_user";
        String dbPassword= "qa_user";

        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        //create statement connection
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from orocrm_contact");

        resultSet.next();
        System.out.println(resultSet.getString("first_name"));
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));
        resultSet.next();
        System.out.println(resultSet.getString(1));

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1)+ " "+ resultSet.getString("first_name"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
