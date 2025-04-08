package jdbcdemo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_CreateTable {

	public static void main(String[] args) throws SQLException {
		//step1 : provide connection details
		String db_url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";
		
		//step2 : Establish the connection
		
		Connection connection = DriverManager.getConnection(db_url, username, password);
		
		//step3 : Create table and query statement
		
		String createDB="create database JDBC_EmplDetails1";
		String useDB="use JDBC_EmplDetails1";
		String createTable="create table Employee_Details(EmplCode int,EmplName VARCHAR(50),EmplPage int,EmplSalary int)";
		String insert="insert into Employee_Details (EmplCode, EmplName, Emplpage, EmplSalary) values (101, 'Jenny', 25, 10000),(102, 'Jacky', 30, 20000),(103, 'Joe', 20, 40000),(104, 'John', 40, 80000),(105, 'Shameer', 25, 90000);";
        String select="select * from Employee_Details";
		
		//step4 : Execute the Statement
		
        Statement smt = (Statement) connection.createStatement();
		smt.execute(createDB);
		smt.execute(useDB);
		smt.execute(createTable);
		smt.executeUpdate(insert);

		
		ResultSet result = smt.executeQuery(select);
		
		while(result.next()) {
			System.out.println(result.getInt("EmplCode")+"  "+result.getString("EmplName")+"  "+result.getInt("EmplPage")+"  "+result.getInt("EmplSalary")+"  ");
		}
		// step5 : close the connection
		connection.close();
	}

}
