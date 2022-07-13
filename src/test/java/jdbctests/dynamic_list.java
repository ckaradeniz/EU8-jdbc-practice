package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamic_list {

    String dbUrl = "jdbc:oracle:thin:@54.91.11.180:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select FIRST_NAME,LAST_NAME,SALARY,JOB_ID\n" +
                "from EMPLOYEES\n" +
                "where ROWNUM < 6");

        //in order to ger column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        //List of maps to keep all information
        List<Map<String,Object>> queryData =new ArrayList<>();

        //number of columns
        int colCount = rsmd.getColumnCount();

        //loop through each row
        while (resultSet.next()){

            Map<String,Object> row = new HashMap<>();

            //some code to fill the dynamically
            for (int i = 1; i<= colCount; i++){
                row.put(rsmd.getColumnName(i),resultSet.getObject(i));
            }

            //add ready map row to the list
            queryData.add(row);
        }




        //print each row inside the list
        for (Map<String,Object> row : queryData){
            System.out.println(row.toString());
        }



        //close connection
        resultSet.close();
        statement.close();
        connection.close();


    }
}
