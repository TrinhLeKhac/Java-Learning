package jdbc;

// JDBC: Java Database Connectivity
// Flow: Java JDBC API >> Java Application >> JDBC Driver >> Database

// Java Database Connectivity with 5 steps:
// Register the Driver class
// Create connection
// Create statement
// Execute queries
// Close connection

// Since JDBC 4.0, explicitly registering the driver is optional
// We just need to put vendor's Jar in the classpath, and then JDBC driver manage can detect and load the driver automatically

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExplain {
}
