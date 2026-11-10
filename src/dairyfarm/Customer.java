

package dairyfarm;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Customer {
   private int id;
   private String name;
   private String contact_number;
   private double amount_of_milk_purchased_per_day;
    public void setId(int x)
    {
        id=x;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public double getAmount_of_milk_purchased_per_day() {
        return amount_of_milk_purchased_per_day;
    }

    public void setAmount_of_milk_purchased_per_day(double amount_of_milk_purchased_per_day) {
        this.amount_of_milk_purchased_per_day = amount_of_milk_purchased_per_day;
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
    public void addCustomer(String name,String contact_number,double amount_of_milk_purchased_per_day){
     try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyfarm", "root", "aeman");
            System.out.println("Connection of add customer established");
            String qry= "insert into customer (customer_name,customer_contactno,milk_purchased) values('"+name+"','"+contact_number+"','"+amount_of_milk_purchased_per_day+"')";
       Statement statement= connection.createStatement();
       statement.executeUpdate(qry);
       connection.close();}
     catch(SQLException ex) {
            Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateCustomer(int id,String name,String contact_number,double amount_of_milk_purchased_per_day){
    
       try {
           Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyfarm", "root", "aeman");
           System.out.println("Connection for updating customer established");
           String qry="UPDATE `customer` SET `customer_name`='"+name+"',`customer_contactno`='"+contact_number+"',`milk_purchased`='"+amount_of_milk_purchased_per_day+"'WHERE `idcustomer`="+id;
           Statement statement=connection.createStatement();
           statement.execute(qry);
           connection.close();
       } catch (SQLException ex) {
           Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    public void deleteCustomer(int id){
    
     try {Connection con;
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyfarm", "root", "aeman");
            String qry="DELETE FROM customer WHERE idcustomer='"+id+"'";
     PreparedStatement statement=con.prepareStatement(qry);
     statement.executeUpdate(qry);
        } catch (SQLException ex) {
            Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewCustomer(){}  
    public void showAmountOfMilkPurchased(int id,int amount_of_milk_purchased_per_day){}

    
}
