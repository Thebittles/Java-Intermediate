//***************************************************************
//
//  Developer:    Instructor
//
//  Program #:    10
//
//  File Name:    ConnectToOracleDBTest.java
//
//  Course:       ITSE 2317 Intermediate Java Programming 
//
//  Due Date:     5/04/2024
//
//  Instructor:   Fred Kumi 
//
//  Description:  A test app for the ConnectToOracleDB class
//
//***************************************************************

import java.sql.*;

public class ConnectToOracleDBTest
{
	Connection connection = null;
	Statement statement = null;
	ConnectToOracleDB dbConnect;
	
	RunSQLQueries queryObj = new RunSQLQueries();
	
	// ***************************************************************
	//
	// Method:      main
	//
	// Description: The main method of the program
	//
	// Parameters:  String array
	//
	// Returns:     N/A
	//
	// **************************************************************
	public static void main(String args[])
	{
		ConnectToOracleDBTest object = new ConnectToOracleDBTest();
		object.createConnectionAndStatement();
        object.setConnectAndStatement();
        
		// Run queries
		object.selectQueryToRun();
		//object.insertsQueryToRun();
		//object.updatesQueryToRun();
		//object.deletesQueryToRun();
		
		object.closeConnection();
    }
	
	// ***************************************************************
	//
	// Method:      createConnection
	//
	// Description: Creates a database connection
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	// **************************************************************
	public void createConnectionAndStatement() 
	{
		try {
			dbConnect = new ConnectToOracleDB();
			
			dbConnect.loadDrivers();
			connection = dbConnect.connectDriver();
	
		    if (connection != null)
		    {
			   System.out.println("\nReceived success connection handle in main TestApp");
			   statement = dbConnect.createQueryStatement();
			   
			   if (statement != null)
			      System.out.println("\nQuery statement created successfully.");
		    }
		}
		catch(Exception exp)
		{
            System.out.println("Something terrible went wrong "  + exp.getMessage());
			System.exit(1);
        }
	}
	
	//***************************************************************
	//
	// Method:      selectQueryToRun
	//
	// Description: This method calls runSelectQuery to run a query
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void setConnectAndStatement() 
	{
		queryObj.setConnection(connection);
		queryObj.setStatement(statement);
    }
	
	//***************************************************************
	//
	// Method:      selectQueryToRun
	//
	// Description: This method calls runSelectQuery to run a query
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void selectQueryToRun() 
	{
	    String query = "SELECT customer# Cust, COUNT(*) Num FROM orders GROUP BY customer#";
		queryObj.runSelectQuery(query);
    }
	
	//***************************************************************
	//
	// Method:      insertQueryToRun
	//
	// Description: This method calls runInsertQuery to run query
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void insertsQueryToRun()
	{
	   String query1 = "INSERT INTO EMPLOYEES values ('Doe', 'John', '123-45-6789')"; 

	   String query2 = "Insert into (Customer#, Lastname, " +
		               " Firstname, Address, City, State, Zip) " +
		  			   "Values(?, ?, ?, ?, ?, ?, ?)";
					  
	   System.out.println("Running insert query one ...");
	   queryObj.runInsertQueryOne(query1);
					
       System.out.println("Running insert query two ...");
	   queryObj.runInsertQueryTwo(query2);
    }
	
	//***************************************************************
	//
	// Method:      updatesQueryToRun
	//
	// Description: This method calls runInsertQuery to run query
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void updatesQueryToRun() 
	{
	   int count = 0;

	   String query1 = "Update Customers " +
		               "Set City = 'DALLAS' where lastName = 'GIANA' ";

	   String query2 = "Update Customers " +
		               "Set State = ? where lastName = ?";

       System.out.println("Running the update query one ...");
	   count = queryObj.runUpdateQueryOne(query1);
	   System.out.println("Number of records updated for query one is " + count);

       System.out.println("\nRunning the update query two ...");	        
	   count = queryObj.runUpdateQueryTwo(query2);
	   System.out.println("Number of records updated for query two is " + count);
    }
	
	//***************************************************************
	//
	// Method:      deletesQueryToRun
	//
	// Description: This method calls runInsertQuery to run query
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void deletesQueryToRun() 
	{
	   int count = 0;
		
	   String query1 = "Delete From Customers where lastName = 'Brown' ";
	   String query2 = "Delete From Customers where lastName = ? ";
							
       System.out.println("Running the delete query one ...");
	   count = queryObj.runDeleteQueryOne(query1);
	   System.out.println("Number of records deleted for query one is " + count);
	        
       System.out.println("\nRunning the delete query two ...");	        
	   count = queryObj.runDeleteQueryTwo(query2);
	   System.out.println("Number of records deleted for query two is " + count);
    }
	
	//***************************************************************
	//
	// Method:      closeConnection
	//
	// Description: Calls closeDBConnection() to close the query
	//              statement and database connection.
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void closeConnection() 
	{
		try {
			dbConnect.closeDBConnection();
		} catch (Exception e) {
			System.out.println("\nClosing the Database Connection failed");
			System.exit(1);
		}
	}
}
