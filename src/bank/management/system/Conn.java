package bank.management.system;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/// SETTING UP JDBC CONNECTION with MySQL

public class Conn {
    //JDBC CONNECTIVITY involve 5 steps :

    Connection c;
    Statement s;
    public Conn(){
        //error handling needed as MySQL is an external entity so prone to errors
        try {
            // 1.) Register the driver -> no need for that now, automatically added to class path via external library

            // 2.) Create Connection
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem", "lazyG", "bhavesh151515");
            // 3.) Create Statement
            s = c.createStatement();  //helps to execute queries
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }

    // 4.) Execute Query
    // Method to execute queries
    public int executeQuery(String query) {
        try {
            return s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            return -1; // Return a value to indicate failure
        }
    }

    // 5.) Close Connection
    // Method to close the connection
    public void closeConnection() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}
