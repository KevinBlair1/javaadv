
package view;
import java.util.*;
import dao.studentdao;
import model.student;

public class testmain {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        student s=new student();
        System.out.println("Enter the Roll number");
        s.setRno(sc.nextInt());
        System.out.println("Enter the student name");        
        s.setName(sc.next());
        studentdao sd=new studentdao();
        sd.insertEle(s);
    }
    
}
