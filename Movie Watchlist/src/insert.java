import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert {

    static final String URL = "jdbc:mysql://localhost:3306/movie";
    static final String USER = "root";
    static final String PASS = "Paritosh@123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many movies do you want to insert? ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for movie " + i);

            System.out.print("Enter Sl Number:");
            int sl_no=sc.nextInt();
            sc.nextLine();

            System.out.print("Enter movie name:");
            String movieName =sc.nextLine();

            System.out.print("Enter genre:");
            String genre =sc.nextLine();

            System.out.print("Enter rating:");
            float rating =sc.nextFloat();
            sc.nextLine(); 
            

            System.out.print("Enter status: ");
            String status = sc.nextLine();

            insertwatch_list(sl_no,movieName, genre, rating, status);
        }

        sc.close();
        System.out.println("\nAll movies inserted successfully 🎬");
    }

    static void insertwatch_list(int sl_no,String movieName, String genre, float rating, String status) {

        String sql = "INSERT INTO watch_list(sl_no,moviename, genre, rating, status) VALUES (?,?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, sl_no);
                ps.setString(2, movieName);
                ps.setString(3, genre);
                ps.setFloat(4, rating);
                ps.setString(5, status);

                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}