import com.sun.source.tree.StatementTree; 
import java.sql.*; 
public class Main { 
public static void main(String[] args) { 
String url = "jdbc:mysql://localhost:3306/java"; 
String user = "root"; 
String password = "Ishika_1"; 
try { 
Connection conn = DriverManager.getConnection(url, user, password); 
Statement s= conn.createStatement(); 
ResultSet rs = s.executeQuery("SELECT * FROM users"); 
while (rs.next()) { 
System.out.println("ID: " + rs.getInt("idUsers") + ", Name: " + rs.getString("name")); 
} 
System.out.println("Connected to the database successfully!"); 
conn.close(); 
} catch (SQLException e) { 
System.out.println("Connection failed!"); 
e.printStackTrace(); 
} 
} 
}
