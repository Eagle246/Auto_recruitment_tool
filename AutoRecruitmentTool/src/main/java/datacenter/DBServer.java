/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacenter;

import objmodels.User;
import objmodels.Candidate;
import java.sql.*;
import objmodels.Account;

/**
 * @author Eagle
 */
public class DBServer {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;
    private Account Acc; 
    private String DB_URL="jdbc:mysql://localhost/hr";
    private String dbUser="root";
    private String dbPass="sapassword";
    public DBServer(){}
//    public DBServer(Account oAcc, String url){
//        Acc = oAcc; 
//        DB_URL = url;
//    }

    public boolean connect() {
        try {
            Class.forName(JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, Acc.AccName, Acc.PW);
            connection = DriverManager.getConnection(DB_URL, dbUser, dbPass);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            // Could not connect to the database
        } 
    }

    public Connection getConnection() {
        connect();
        return connection;
    }

    public ResultSet GetCandidate(Candidate oCandidate) {
        String query = "SELECT * FROM `candidate`";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void AddCandidate(Candidate oCandidate) {
        String query = "INSERT INTO `candidate` (`id`, `name`, `phone`, `job_title`, `cv_date`, `experience`, `expectation`, `location`, `referral`, `latest_result`)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(2, oCandidate.getName());
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void UpdateCandidate(String id, Candidate oCandidate) {
        String query = "UPDATE `candidate` SET `job_title` = 'Test' WHERE `candidate`.`id` = " + id;
    }

    public boolean AddUser(User oUser) {
        return true;
    }

}
