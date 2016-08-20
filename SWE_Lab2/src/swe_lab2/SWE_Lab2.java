package swe_lab2;
import java.sql.*; 
import java.util.Scanner;
/**
 *
 * @author Yash Sharma
 */
public class SWE_Lab2 {

    public static void main(String[] args) {
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            //here swe_lab2 is database name, root is username and 123456 is the password  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swe_lab2","root","123456");  
            Statement stmt = con.createStatement();  
            ResultSet rs;
                        
            System.out.println("Welcome to IIITA Student Management System!\n");
            StudentManager man = new StudentManager();
            while( true ){
                System.out.println("1.Add new record\n2.Delete a record\n3.Update a record\n4.Search for a record\n5.Display all records\n6.Exit");
                System.out.print("Enter an option to continue...\t");

                Scanner in = new Scanner(System.in);
                int choice = in.nextInt();

                if(choice == 6){
                    System.out.println("goodbye!");
                    break;
                }

                switch (choice){
                    case 1: // Add new record
                        stmt.executeUpdate(man.addRecord());
                        System.out.println("\nRecord successfully added.\n");
                        break;
                    case 2: // Delete a record
                        stmt.executeUpdate(man.deleteRecord());
                        System.out.println("\nRecord successfully deleted.\n");
                        break;
                    case 3: // Update a record
                        stmt.executeUpdate(man.updateRecord());
                        System.out.println("\nRecord successfully updated.\n");
                        break;
                    case 4: // Search for a record
                        rs = stmt.executeQuery(man.searchRecord());
                        System.out.println("\n");
                        while(rs.next()){
                            System.out.println( rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) 
                                    + "  " + rs.getString(4) + "  " + rs.getString(4) + "  " + rs.getInt(5)
                                    + "  " + rs.getString(6) + "  " + rs.getFloat(7) );
                        }
                        System.out.println("\n");
                        break;
                    case 5: // Display all records
                        rs = stmt.executeQuery(man.displayAllRecords());
                        System.out.println("\n");
                        while(rs.next()){
                            System.out.println( rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) );
                        }
                        System.out.println("\n");
                        break;
                    default:
                        System.out.println("\nThis is not a valid response. Please try again...\n");
                        break;
                }   
            }
            
            con.close();  
            
        } catch(Exception e){ System.out.println(e);}  
    }
}