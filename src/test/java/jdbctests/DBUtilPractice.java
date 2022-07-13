package jdbctests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {

    @Test
    public void test1(){

        //create connection
        DBUtils.createConnection();

        String query = "select FIRST_NAME,LAST_NAME,SALARY,JOB_ID\n" +
                "from EMPLOYEES\n" +
                "where ROWNUM < 6";

        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        //print the result
        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());

        }

        //close the connection
        DBUtils.destroy();
            
    }

    @Test
    public void test2(){

        //create connection
        DBUtils.createConnection();

        String query = "select FIRST_NAME,LAST_NAME,SALARY,JOB_ID\n" +
                "from EMPLOYEES\n" +
                "where ROWNUM < 2";

        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        System.out.println(rowMap.toString());


        //close the connection
        DBUtils.destroy();


    }

}
