package com.FaithSurgery.configurartions;

import java.sql.*;




public class DatabaseConnection {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/SurgeryDB";

    static final String USER = "faith";
    static final String PASS = "1234";
    private int count = 0;

    Connection conn = null;
public int countPatients() {
    try {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // STEP 2: Open a connection
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected database successfully...");


        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery("select count(*) from PATIENT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.next()) {
                try {
                    count = rs.getInt(1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Count is" + count);
    }catch (Exception e)
    {
        e.getLocalizedMessage();
    }
    return  count;
 }
}
