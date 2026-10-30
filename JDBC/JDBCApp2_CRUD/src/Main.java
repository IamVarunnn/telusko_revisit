import java.sql.*;

public class Main {

    static void main() throws Exception{



        int sid = 10;
        String sname = "Alex";
        int marks = 68;

        String url = "jdbc:postgresql://localhost:5432/Demo";
        String user = "postgres";
        String password = "";
        String query = "insert into student values (?, ?, ?)";

        Connection connection = DriverManager.getConnection(url, user, password);


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, sid);
        preparedStatement.setString(2, sname);
        preparedStatement.setInt(3, marks);

        preparedStatement.execute();

        connection.close();

    }
}
