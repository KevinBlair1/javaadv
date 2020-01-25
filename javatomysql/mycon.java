
package connection;
import java.sql.*;
public class mycon {
    static Connection con=null;
    static{
    try {        
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded");
    }
    catch (ClassNotFoundException e) 
    {
            System.out.println(e);
        
        }
    
    }
    public static Connection getConnection()
    {
        try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dj2","root","root");
        System.out.println("Connected to my sql");
    } catch (SQLException e) {
            System.out.println(e);
    }
       return con;
    
}
}