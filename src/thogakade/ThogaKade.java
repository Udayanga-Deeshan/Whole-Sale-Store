
package thogakade;
import java.sql.*;


public class ThogaKade {

   
    public static void main(String[] args) {
        try{
//           String id = "C011";
//           String name = "Udayanga";
//           String address =  "makola";
//            double salary = 5000;
            
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade","root","root123");
        String SQL = "Select * from Customer";
        Statement stm = connection.createStatement();
        
        
            ResultSet result = stm.executeQuery(SQL);
            while(result.next()){
                String id=result.getString("id");
            String name = result.getString("name");
            String address=result.getString("address");
            double salary=result.getDouble("salary");
            System.out.println(id+"\t"+name+"\t"+address+"\t"+salary);
            }
            
            
            
            
        
        }catch(ClassNotFoundException ex){
            System.out.println("Driver not Fount");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
