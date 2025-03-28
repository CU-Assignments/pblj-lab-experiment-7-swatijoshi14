import java.sql.*; 
class Sql { 
private Connection c; 
private static int numberOfPeople = 1; 
Sql() throws Exception { 
c = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Raghav_1"); 
System.out.println("Database connected successfully!"); 
} 
public void addRecord(String name, int number) throws Exception { 
String query = "INSERT INTO java.users VALUES (" +numberOfPeople+",'"+ name + "', " 
+ number + ");"; 
System.out.println("Executing Query: " + query); 
try (Statement s = c.createStatement()) { 
int rowsInserted = s.executeUpdate(query); 
System.out.println("Rows affected: " + rowsInserted); 
if (rowsInserted > 0) { 
System.out.println("Record inserted successfully!"); 
numberOfPeople++; 
} else { 
System.out.println("Insertion failed!"); 
} 
} } 
public void update(int id, String name) throws Exception { 
String query = "UPDATE users SET name='" + name + "' WHERE id=" + id; 
System.out.println("Executing Query: " + query); 
try (Statement s = c.createStatement()) { 
int rowsUpdated = s.executeUpdate(query); 
System.out.println("Rows affected: " + rowsUpdated); 
if (rowsUpdated > 0) { 
System.out.println("Record updated successfully!"); 
} else { 
System.out.println("Update failed! Record not found."); 
} 
} } 
public void readRecords() throws Exception { 
String query = "SELECT * FROM users"; 
System.out.println("Executing Query: " + query); 
try (Statement s = c.createStatement(); ResultSet rs = s.executeQuery(query)) { 
System.out.println("\nUser Records:"); 
boolean foundRecords = false; 
while (rs.next()) { 
foundRecords = true; 
System.out.println("ID: " + rs.getInt("id") + 
", Name: " + rs.getString("name") + 
", Number: " + rs.getInt("number")); 
} 
if (!foundRecords) { 
System.out.println("No records found in the database."); 
} 
} } 
public void closeConnection() throws Exception { 
c.close(); 
System.out.println("Database connection closed."); 
} 
} 
public class CRUD { 
public static void main(String[] args) { 
try { 
Sql db = new Sql(); 
db.addRecord("Raghav", 100); 
db.readRecords(); 
db.update(1, "John Doe"); 
db.readRecords(); // Read again to confirm update 
db.closeConnection(); 
} catch (Exception e) { 
e.printStackTrace(); 
} 
} 
} 
