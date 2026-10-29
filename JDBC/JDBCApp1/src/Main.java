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

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("Connection Established");
    }
}
