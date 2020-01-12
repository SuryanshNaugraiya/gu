import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Test
{
    public static void main(String[] args) throws Exception
    {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gladb5?serverTimezone=UTC", "root", "");
        if (connection != null)
        {
            System.out.println("connection done");
        }
        Test t = new Test();
        t.view();
        t.insert();
        t.view();
        t.delete();
        t.view();
        t.update();
        t.view();
    }



    public void insert() throws Exception
        {
            Scanner sc = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gla3?serverTimezone=UTC", "root", "");
            while(true)
            {
                System.out.println("enter roll number");
                int r = sc.nextInt();
                System.out.println("enter name");
                 String n = sc.next();
                System.out.println("enter year");
                int y = sc.nextInt();
                System.out.println("enter cpi");
                int c = sc.nextInt();
                String insertquery = "insert into student values(?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(insertquery);
                pst.setInt(1, r);
                pst.setString(2, n);
                pst.setInt(3, y);
                pst.setInt(4, c);
                pst.executeUpdate();
                System.out.println("do u want to insert more elemaents [yes/no]");
                String option = sc.next();
                if (option.equalsIgnoreCase("no"))
                {
                    break;
                }
            }
        }




        public void view() throws Exception
        {
            ArrayList<String> l=new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gladb5?serverTimezone=UTC","root","");
            Statement st= connection.createStatement();
            ResultSet rs=st.executeQuery("Select * from student");
            while(rs.next())
            {
                l.add(rs.getString(2));
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
            }
            System.out.println("do u want to see the arraylist of names[yes/no]");
            String b= sc.next();
            if(b.equalsIgnoreCase("yes"))
            {
                System.out.println(l);
            }
        }

    public void delete() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gladb53?serverTimezone=UTC","root","");
        while(true)
        {
            System.out.println("enter the roll number u want to delete");
            int r = sc.nextInt();
            String deletequery = "delete from student where rollNumbrer=?";
            PreparedStatement pst = connection.prepareStatement(deletequery);
            pst.setInt(1, r);
            pst.executeUpdate();
            System.out.println("do u want to delete more elements[yes/no]");
            String option = sc.next();
            if(option.equalsIgnoreCase("no"))
            {
                break;
            }
        }

    }


    public void update() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gladb5?serverTimezone=UTC","root","");
        while(true)
        {
            System.out.println("enter name to modify");
            String n = sc.next();
            System.out.println("enter the roll no. whose name to modify");
            int r = sc.nextInt();
            String updatequery = "update student set name = ? where rollNumbrer = ?";
            PreparedStatement pst = connection.prepareStatement(updatequery);
            pst.setString(1,n);
            pst.setInt(2,r);
            pst.executeUpdate();
            System.out.println("do u want to update more elements[yes/no]");
            String option = sc.next();
            if(option.equalsIgnoreCase("no"))
            {
                break;
            }
        }
    }
}