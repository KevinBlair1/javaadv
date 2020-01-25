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
}
