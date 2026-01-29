import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root";
        String pass = "Paritosh@123";

        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter how many record you want to enter : ");
        int n=sc.nextInt();
        System.out.println("Enter the records : ");
      
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
          for(int i=0;i<n;i++){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sc.next());
            ps.setString(2, sc.next());

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted");
          }
            con.close();
        }
            catch (Exception e) {
            e.printStackTrace();
        }
    }
}