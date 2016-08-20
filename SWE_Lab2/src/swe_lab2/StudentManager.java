package swe_lab2;

import java.util.Scanner;

/**
 *
 * @author Yash Sharma
 */
public class StudentManager {
    
    public String addRecord(){
        String name, fathersName, address, mobile;
        int age;
        float cgpa;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the student's name\t");
        name = in.nextLine();
        System.out.print("Enter the father's name\t");
        fathersName = in.nextLine();
        System.out.print("Enter the address\t");
        address = in.nextLine();
        System.out.print("Enter the mobile number\t");
        mobile = in.nextLine();
        System.out.print("Enter the age\t");
        age = in.nextInt();
        System.out.print("Enter the cgpa\t");
        cgpa = in.nextFloat();
        
        String query = "INSERT INTO students " +
                " ( student_name, student_fathers_name, student_address, student_age, student_mobile, student_cgpa ) " +
                " VALUES ( '" + name +  "', '" + fathersName + "', '" + address + "', " + age + ", '" + mobile + "', " + cgpa +");" ;
        return query;
    }
    
    public String deleteRecord(){
        System.out.println("Enter student id\t");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        String query = "DELETE FROM students WHERE student_id=" + id + ";";
        return query;
    }
    
    public String updateRecord(){
        System.out.println("Enter student id\t");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        String name, fathersName, address, mobile;
        int age;
        float cgpa;
        in.nextLine();
        System.out.print("Enter the student's name\t");
        name = in.nextLine();
        System.out.print("Enter the father's name\t");
        fathersName = in.nextLine();
        System.out.print("Enter the address\t");
        address = in.nextLine();
        System.out.print("Enter the mobile number\t");
        mobile = in.nextLine();
        System.out.print("Enter the age\t");
        age = in.nextInt();
        System.out.print("Enter the cgpa\t");
        cgpa = in.nextFloat();
        
        String query = "UPDATE students SET student_name='" + name + "', student_fathers_name='" + fathersName + "', student_address='" +  
                address + "', student_mobile='" + mobile + "', student_age=" + age + ", student_cgpa=" + cgpa 
                + " WHERE student_id=" + id + ";";
        
        return query;
    }
    
    public String searchRecord(){
        System.out.println("Enter student id\t");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        
        String query = "SELECT * FROM students WHERE student_id=" + id + ";";
        return query;
    }
    
    public String displayAllRecords(){
        String query = "SELECT student_id, student_name, student_age FROM students ORDER BY student_name ASC;";
        return query;
    }
}
