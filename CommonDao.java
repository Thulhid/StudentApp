import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommonDao {

    public static ResultSet get(String quary) {

        ResultSet rs = null;

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "90896262");
            Statement st = con.createStatement();
            rs = st.executeQuery(quary);
        } catch (Exception e) {
            System.out.println("Can't Connect as :" + e.getMessage());

        }

        return rs;

    }
}