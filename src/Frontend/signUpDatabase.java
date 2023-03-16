package Frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class signUpDatabase {
    String url = "jdbc:mysql://localhost/CMS";
    String username = "root";
    String password = "";
    void create(){
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE Course(CourseID int NOT NULL, CourseName varchar(50) NOT NULL, NoOfSeats int NOT NULL)";
            String query1 = "CREATE TABLE Admin(AdminID int PRIMARY KEY AUTO_INCREMENT, Username varchar(50) NOT NULL, PhoneOrMail varchar(50), Password varchar(50) NOT NULL)";
            String query2 = "CREATE TABLE Instructor(InstructorID int PRIMARY KEY AUTO_INCREMENT, Username varchar(50) NOT NULL, PhoneOrMail varchar(50) NOT NULL, Password varchar(50) NOT NULL)";
            String query3 = "CREATE TABLE Student(StudentID int PRIMARY KEY AUTO_INCREMENT, Username varchar(50) NOT NULL, PhoneOrMail varchar(50) NOT NULL, Course varchar(50) NOT NULL, Password varchar(50) NOT NULL)";
            //create the statement
            Statement statement = connect.createStatement();
            statement.execute(query);
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);

            System.out.println("Table created ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    public static void main(String[] args) {
        signUpDatabase create = new signUpDatabase();
        create.create();
    }
}