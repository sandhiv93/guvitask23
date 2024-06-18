package task23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

    public static void main(String[] args) throws SQLException {


        //Database connection details

        String db_url="jdbc:mysql://localhost:3306/";
        String userName ="root";
        String password = "root";

        //Establish the connection

        Connection connection = DriverManager.getConnection(db_url, userName, password);

        //to perform operation
        Statement  statement =connection.createStatement();
        //create database
        String create_db ="create database employee";
        //use the database
        String use_db = "use employee";
        //create the table
        String create_table ="create table employeedata ("
                + "empcode int,"
                + "empname varchar(15),"
                + "emppage int,"
                + "esalary bigint)";
        //insert the values to the table
        String insert_values = "insert into employeedata values "
                + "(101,'Jenny',25,10000),"
                + "(102,'Jacky',30,20000),"
                + "(103,'Joe',20,40000),"
                + "(104,'John',40,80000),"
                + "(105,'Shameer',25,90000)";
        //execute the query statements
        statement.execute(create_db);
        statement.execute(use_db);
        statement.execute(create_table);
        statement.executeUpdate(insert_values);


        //select all values in table
        String select ="select * from employeedata";

        //execute the select query
        ResultSet selecttable= statement.executeQuery(select);

        //iterate and print the values in console
        while(selecttable.next()) {
            System.out.println(selecttable.getInt("empcode")+ "   " + selecttable.getString("empname")+"     "+ selecttable.getInt("emppage")+"      "+selecttable.getInt("esalary"));
        }


        //close the jdbc connection
        connection.close();











    }

}