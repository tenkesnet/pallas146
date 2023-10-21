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
                    .getConnection("jdbc:postgresql://localhost:5432/pallas?currentSchema=auto",
                            "pallas", "Oktato123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "select azon,szin,rendszam from auto.sz_auto where szin like ? and azon>? order by azon asc";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, "%%");
            st.setInt(2, 0);
            ResultSet result = st.executeQuery();
            while (result.next()) {
                System.out.print("Azon: " + result.getInt("azon"));
                System.out.print(" ; Szin: " + result.getString("szin"));
                System.out.println(" ; Rendszám: " + result.getString("rendszam"));
            }
            // stmt.executeUpdate(sql);

            //st = c.prepareStatement("Insert into sz_auto values (13,'rózsaszín','2023-10-20',1200000,1,'AAA-001')");
            //st.execute();

            st = c.prepareStatement("delete from sz_auto where azon=? ");
            st.setInt(1, 12);
            st.execute();


            //stmt.addBatch(String.format("insert into words (szo,gyakor,szofajta) values ('%s',%d,'%s')",));


            stmt.executeBatch();
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
