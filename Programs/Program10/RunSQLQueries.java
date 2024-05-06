//***************************************************************
//
//  Developer:    Instructor
//
//  Program #:    Sample program for Program 10
//
//  File Name:    RunSQLQueries.java
//
//  Course:       ITSE 2317 Intermediate Java Programming  
//
//  Due Date:     5/04/2024     
//
//  Instructor:   Fred Kumi 
//
//  Description:  Sample program for Program 10
//
//***************************************************************

import java.sql.*;
import java.util.Scanner;

public class RunSQLQueries
{
	private Connection connection;
	private Statement statement;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
	
	//***************************************************************
	//
	// Method:      RunQueries
	//
	// Description: Constructor
	//
	// Parameters:  Connection
    //
	// Returns:     N/A
	//
	//**************************************************************
	public RunSQLQueries()
	{
		connection = null;
		statement = null;
	}
	
	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
	
	public void setStatement(Statement statement)
	{
		this.statement = statement;
	}
	
	//***************************************************************
	//
	// Method:      runSelectQuery
	//
	// Description: Runs the query
	//
	// Parameters:  queryToRun the query to run
    //
	// Returns:     N/A
	//
	//**************************************************************
	public void runSelectQuery(String queryToRun)
	{
		int cust = 0;
        int count = 0;
 
		// Execute the query and get our result
		try {
            System.out.println("Creating statement...");
		    resultSet = statement.executeQuery(queryToRun);
			
			System.out.println("Customer #         Count");
			while (resultSet.next())
			{
				cust = resultSet.getInt("Cust");
				count = resultSet.getInt("Num");
				System.out.printf("%6d%16d%n", cust, count);
			} // End of while loop
		}
		catch (SQLException exp)
		{
		   System.out.println("SQL Error Message: " + exp.getMessage());
		} 
        catch(Exception exp)
		{
           System.out.println("Failed to run query. \n" + exp.getMessage());
        }
	}
	
	//***************************************************************
	//
	// Method:      runInsertQueryOne
	//
	// Description: Runs insert queries examples using the
	//              prepareStatement method of connection
	//
	// Parameters:  Insert query to run
    //	
	// Returns:     N/A
	//
	//**************************************************************
	public int runInsertQueryOne(String queryToRun) 
	{
        int count = 0;
		
		try {
            System.out.println("Creating statement...");
            PreparedStatement prepStatement = connection.prepareStatement(queryToRun);
			count = prepStatement.executeUpdate();
		}
		catch (SQLException exp)
		{
		   System.err.println("SQL Error Message: " + exp.getMessage());
		} 
        catch(Exception exp)
		{
           System.err.println("Failed to run query. \n" + exp.getMessage());
        }
		
        return count;
	}
	
	//***************************************************************
	//
	// Method:      runInsertQueryTwo
	//
	// Description: Runs insert queries examples using the
	//              prepareStatement method of connection
	//
	// Parameters:  Insert query to run
    //	
	// Returns:     N/A
	//
	//**************************************************************
	public int runInsertQueryTwo(String queryToRun) 
	{
        int count = 0;
        
		System.out.print("Enter customer number: ");
		int customerNmbr = input.nextInt();

		System.out.print("Enter customer's last name: ");
		String lastName = input.next();
		
		System.out.print("Enter customer's first name: ");
		String firstName = input.next();
		
		System.out.print("Enter customer's address: ");
		String address = input.nextLine();
		
		System.out.print("Enter customer's city: ");
		String city = input.next();
		
		System.out.print("Enter customer's state: ");
		String state = input.next();
		
		System.out.print("Enter customer's zip code: ");
		String zipCode = input.next();

		// Execute the query
		try {
            System.out.println("Creating preppare statement...");
            PreparedStatement prepStatement = connection.prepareStatement(queryToRun);

			prepStatement.setInt(1, customerNmbr);
			prepStatement.setString(2, lastName);
			prepStatement.setString(3, firstName);
			prepStatement.setString(4, address);
			prepStatement.setString(5, city);
			prepStatement.setString(6, state);
			prepStatement.setString(7, zipCode);
			
			count = prepStatement.executeUpdate();
		}
		catch (SQLException exp)
		{
		   System.out.println("SQL Error Message 1: " + exp.getMessage());
		} 
        catch(Exception exp)
		{
           System.out.println("Failed to run query. \n" + exp.getMessage());
        }
		
		return count;
	}
	
	//***************************************************************
	//
	// Method:      runUpdateQueryOne
	//
	// Description: Runs the update query
	//
	// Parameters:  Query to run
    //	
	// Returns:     The update count
	//
	//**************************************************************
	public int runUpdateQueryOne(String queryToRun)
	{
        int count = 0;
        
		// Execute the query
		try {
		    count = statement.executeUpdate(queryToRun);
		}
		catch (SQLException exp)
		{
		   System.err.println("SQL Error Message: " + exp.getMessage());
		} 
        catch(Exception exp)
		{
           System.err.println("Failed to run query. \n" + exp.getMessage());
        }
		
		return count;
    }
	
	//***************************************************************
	//
	// Method:      runUpdateQueryTwo
	//
	// Description: Runs the update query
	//
	// Parameters:  Query to run
    //	
	// Returns:     The update count
	//
	//**************************************************************
	public int runUpdateQueryTwo(String queryToRun)
	{
        int count = 0;
		
		System.out.print("\nEnter customer's lastname to update: ");
		String lastName = input.next();

        System.out.println("Creating prepare statement...");
        
		// Execute the query
		try {
            PreparedStatement prepStatement = connection.prepareStatement(queryToRun);
			prepStatement.setString(1, lastName);
			count = prepStatement.executeUpdate();
		}
		catch (SQLException exp)
		{
		   System.err.println("SQL Error Message 1: " + exp.getMessage());
		} 
        catch(Exception exp)
		{
           System.err.println("Failed to run query. \n" + exp.getMessage());
        }
		
		return count;
	}

	//***************************************************************
	//
	// Method:      runDeleteQueryOne
	//
	// Description: Runs the delete query
	//
	// Parameters:  Query to run
    //	
	// Returns:     The delete count
	//
	//**************************************************************
	public int runDeleteQueryOne(String queryToRun)
	{
        int count = 0;
        
		// Execute the query
		try {
		    count = statement.executeUpdate(queryToRun);
		}
		catch (SQLException exp)
		{
		   System.err.println("SQL Error Message: " + exp.getMessage());
		} 
        catch(Exception exp)
		{
           System.err.println("Failed to run query. \n" + exp.getMessage());
        }
		
		return count;
	}
	
	//***************************************************************
	//
	// Method:      runDeleteQueryTwo
	//
	// Description: Runs the delete query
	//
	// Parameters:  Query to run
    //	
	// Returns:     The delete count
	//
	//**************************************************************
	public int runDeleteQueryTwo(String queryToRun)
	{
        int count = 0;
		
		System.out.print("\nEnter customer's lastname to delete: ");
		String lastName = input.next();

        System.out.println("Creating prepare statement...");
        
		// Execute the query
		try {
            PreparedStatement prepStatement = connection.prepareStatement(queryToRun);
			prepStatement.setString(1, lastName);
			count = prepStatement.executeUpdate();
		}
		catch (SQLException exp)
		{
		   System.err.println("SQL Error Message 1: " + exp.getMessage());
		} 
        catch(Exception exp)
		{
           System.err.println("Failed to run query. \n" + exp.getMessage());
        }
		
		return count;
	}
}
