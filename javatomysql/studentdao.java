package dao;
import connection.mycon;
import java.sql.*;
import model.student;
public class studentdao {
    public void insertEle(student s)
    {
        Connection con=null;
        String sql;
        sql="insert into student values(?,?)";
        PreparedStatement p1=null;
        con=mycon.getConnection();
        try {
        p1=con.prepareStatement(sql);
        p1.setInt(1,s.getRno());
        p1.setString(2,s.getName());
        int n=p1.executeUpdate();
        System.out.println("values inserted ");
          } catch (Exception e) {
              System.out.println(e);
        }
    }

public void testSearch(student s)
    {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    con=mycon.getConnection();
    try{
    String sql;
    sql="select * from student";
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next())
    {
        System.out.print(rs.getInt(1));
        System.out.println(  rs.getString(2));
    }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
 
    
}
