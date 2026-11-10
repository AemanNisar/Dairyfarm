
package dairyfarm;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cow {
    private int id;
    private double weight;
    private double milk_production_per_day;
    private double money_spent_on_cow;

   
    public void setMoney_spent_on_cow(double money_spent_on_cow) {
        this.money_spent_on_cow = money_spent_on_cow;
    }
    
     public double getMoney_spent_on_cow() {
        return money_spent_on_cow;
    }

    
    //Getters and Setters
    public void setId(int x)
    {
        id=x;
    }
    public int getId()
    {
        return id;
    }
    
    public void setWeight(double x)
    {
        weight=x;
    }
    public double getWeight()
    {
        return weight;
    }
     public void setMilk_production_per_day(double x)
    {
        milk_production_per_day=x;
    }
    public double getMilk_production_per_day()
    {
        return milk_production_per_day;
    }
    
    
    //Functions or Methods
    public void addCow(double weight,double milk_production_per_day,double money_spent_on_cow)
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyfarm","root","aeman");
           //DriverManager provides methods for establishing database connections.
            System.out.println("Connection Established");
            
            //writing query
            String qry= "insert into cow (cow_weight,cow_milk_production_per_day,money_spent_on_cow) values('" +weight+"','"+milk_production_per_day+"', '"+money_spent_on_cow+"')";
            /*This is the SQL query itself. It inserts a new row into the "cow" table with values for three 
            columns: "cow_weight", "cow_milk_production_per_day", and "money_spent_on_cow". The values to be
            inserted are obtained from the variables weight, milk_production_per_day, and money_spent_on_cow,       
            respectively.
           */
            
            Statement statement=connection.createStatement();
            /* Statement object helps you send these queries or updates to the database and handles the
            communication between your Java code and the database system*/
            
            statement.executeUpdate(qry);  //to insert ,delete or update values in database
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error found", "Error", 2);
        }
    }
    public void updateCow(int id,double weight, double milk_production_per_day, double money_spent_on_cow){
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyfarm","root","aeman");
            System.out.println("Connection for updating cow's info established");
            String qry="UPDATE `cow` SET `cow_weight` = '" + weight + "', `cow_milk_production_per_day` = '" + milk_production_per_day + "', `money_spent_on_cow` = '" + money_spent_on_cow + "' WHERE `cow_id` = " + id;            
            Statement statement=con.createStatement();
            statement.executeUpdate(qry);
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
    }
    public void deleteCow(int id){
    
      
      
           
        try {Connection con;
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyfarm", "root", "aeman");
            String qry="DELETE FROM cow WHERE cow_id='"+id+"'";
     PreparedStatement statement=con.prepareStatement(qry);
     statement.executeUpdate(qry);
        } catch (SQLException ex) {
            Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     
       }
       
       
    
    public void viewCow()
    {
      
    }
       
    
}
