import java.sql.*;

public class Main {

    static void main() throws Exception {

        // import package
        // load and register
        // create connection
        // create statement
        // execute statement
        // process the results
        // close

//        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/Demo";
        String user = "postgres";
        String password = "";
        String query = "select * from student";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection Established");



        Statement statement = connection.createStatement();
        ResultSet rs =  statement.executeQuery(query);
//
//        rs.next();
//        String name =  rs.getString("sname");
//
//        System.out.println(name);

        while(rs.next()){
            System.out.println(rs.getString("sname"));
        }





        connection.close();

        System.out.println("Connection Closed");

    }
}
