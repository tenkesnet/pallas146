package szotar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class peldadb {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/pallas?currentSchema=public",
                            "pallas", "Oktato123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "select * from book";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet result = st.executeQuery();

            while (result.next()) {
                System.out.print("Id: " + result.getInt("book_id"));
                System.out.print(" ; Name: " + result.getString("title"));
                System.out.println(" ; Fizetés: " + result.getString("isbn"));
            }
            // stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
}
