package dairyfarm;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee {
    private int id;
    private String name;
   private String contact_number;
   private double salary;
    public void setId(int x)
    {
        id=x;
    }
    public int getId()
    {
        return id;
    }
    public void setName(String x)
    {
        name=x;
    }
    public String getName()
    {
        return name;
    }
     public void setContactNumber(String x)
    {
        contact_number=x;
    }
    public String getContactNumber()
    {
        return contact_number;
    }
     public void setSalary(int x)
    {
        salary=x;
    }
    public double getSalary()
    {
        return salary;
    }
    
    public void addEmployee(String name,String contact_number,double salary)
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "sehrish1106");
            System.out.println("Connection of add employee established");
            String qry= "insert into employee (emp_Name,emp_Phnoe_No,emp_Salary) values('"+name+"','"+contact_number+"','"+salary+"')";
       Statement statement= connection.createStatement();
       statement.executeUpdate(qry);
       
       connection.close();
       
       
       
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void updateEmployee(int id,String name,String contact_number,double salary){
     try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","sehrish1106");
            System.out.println("Connection for updating employee's info established");
            String qry="UPDATE `employee` SET `emp_Name`='"+name+"',`emp_Phone_Number`='"+contact_number+"',`emp_Salary`='"+salary+"'";
            Statement statement=con.createStatement();
            statement.executeUpdate(qry);
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    public void deleteEmployee(int id){
     try {Connection con;
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "sehrish1106");
            String qry="DELETE FROM employee WHERE emp_Id='"+id+"'";
     PreparedStatement statement=con.prepareStatement(qry);
     statement.executeUpdate(qry);
        } catch (SQLException ex) {
            Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewEmployee(){} 
   public void showPaidOrUnpaidStatus(int id){}
public void updateCombo()
{
       
}
    
}
