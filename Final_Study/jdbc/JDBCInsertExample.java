import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertExample {
    public static void main(String[] args) {
        // MySQL JDBC driver
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        // Database connection URL
        String dbUrl = "jdbc:mysql://localhost:3306/testdb"; // 'testdb' is the database name
        // Database credentials
        String username = "yourUsername"; // your database username
        String password = "yourPassword"; // your database password
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // Load the JDBC driver
            Class.forName(jdbcDriver);
            
            // Establish the connection
            conn = DriverManager.getConnection(dbUrl, username, password);
            
            // Define the SQL insert statement with placeholders for parameterization
            String insertSQL = "INSERT INTO employees (id, first_name, last_name, age) VALUES (?, ?, ?, ?)";
            
            // Prepare the SQL statement
            pstmt = conn.prepareStatement(insertSQL);
            
            // Set parameter values
            pstmt.setInt(1, 101); // Assuming 'id' is the primary key
            pstmt.setString(2, "John");
            pstmt.setString(3, "Doe");
            pstmt.setInt(4, 30);
            
            // Execute the insert statement
            int rowsAffected = pstmt.executeUpdate(); // Returns the number of affected rows
            
            System.out.println("Rows inserted: " + rowsAffected);
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error executing SQL statement.");
            e.printStackTrace();
        } finally {
            // Ensure the statement and connection are closed
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
