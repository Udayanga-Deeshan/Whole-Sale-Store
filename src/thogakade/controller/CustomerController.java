/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;
import thogakade.model.Customer;
import java.sql.*;
import thogakade.db.DBConnection;


public class CustomerController {
    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
       DBConnection dbc = DBConnection.getInstance();
       Connection connection = dbc.getConnection();
       PreparedStatement  stm = connection.prepareStatement("Insert into Customer values(?,?,?,?)");
        stm.setObject(1,customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());
        
        int result = stm.executeUpdate();
        return result > 0; 
    }
    
    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm =connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * from Customer where id ='"+id+"' ");
        if(rst.next()){
            return new Customer(rst.getString("id"),rst.getString("name"),rst.getString("address"),rst.getDouble("salary"));
        }
        
        return null;
        
    }
}
