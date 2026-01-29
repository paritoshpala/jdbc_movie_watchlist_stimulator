import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root";
        String pass = "Paritosh@123";
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(url, user, pass);
        //  String readSql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement("SELECT * FROM watch_list");
            ResultSet rs = ps.executeQuery();

            // System.out.println("\ns.no.| movie | genre | ratings | status");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("sl_no") + " | " +
                        rs.getString("moviename") + " | " +
                        rs.getString("genre")+" " +
                        rs.getInt("rating")+" | " +
                        rs.getString("status")
                );
            }
    }catch (Exception e) {
            e.printStackTrace();
        }
    
}
}