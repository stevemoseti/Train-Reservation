package Theapplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen Matara
 */
public class DbConnection {
    String host="jdbc:mysql://localhost:3306/mashujaaexpress";
    String user="root";
    String pass="";
    
    Connection conn;
    
    public Connection getConnection(){
        
        try{
            
        conn=DriverManager.getConnection(host, user, pass);
        JOptionPane.showMessageDialog(null,"  connection successful");
            return conn;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
            return null;
    }
    
    
    }
    //inserting account into the database if you dont have one
    public void insertloginregister(String firstname, String surname, String password, String confirmpassword, String username,String dateofbirth){
         String q="INSERT into loginregister(firstname,surname,password,confirmpassword,username,dateofbirth) VALUES(?,?,?,?,?,?)";
         int k=0;
         try{
         
        
        PreparedStatement st=getConnection().prepareStatement(q);
        st.setString(1,firstname);
        st.setString(2,surname);
        st.setString(3,password); 
         st.setString(4,confirmpassword); 
          st.setString(5,username); 
          st.setString(6,dateofbirth);
      if(st.executeUpdate()>k){
          
          
          JOptionPane.showMessageDialog(null,username+"  Regestered Successfully");
   }
         }catch(SQLException ex){
JOptionPane.showMessageDialog(null,ex.getMessage());
    
}
}

    public void inserttobooking(String firstname, String surname, String address, String idpno, String email, String phoneno, String from, String to,String accomodation, String total) {
String k="INSERT into booking (firstname,surname,address,idpno,email,phoneno,startfrom,destination,accomodation,total)VALUES(?,?,?,?,?,?,?,?,?,?)";
    int z=0;
    try{
        PreparedStatement st=getConnection().prepareStatement(k);
        st.setString(1,firstname);
        st.setString(2,surname);
        st.setString(3,address);
        st.setString(4,idpno);
        st.setString(5, email);
        st.setString(6,phoneno);
        st.setString(7,from);
        st.setString(8, to);
        st.setString(9, accomodation);
        st.setString(10, total);
        
              if(st.executeUpdate()>z){
          JOptionPane.showMessageDialog(null,firstname+"  you have Booked A Seat Successfully");
          JOptionPane.showMessageDialog(null, "THANK YOU FOR CORPARATING  WITH US");
   }
   }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

     public void updatebooking(String firstname, String surname, String address, String idpno, String email, String phoneno, String from, String to, String accomodation, String total) {
     String j="update booking SET firstname=?,surname=?,address=?,email=?,phoneno=?,startfrom=?,destination=?,accomodation=?,total=? where idpno=?";   
    
     int x=0;
     try{
        PreparedStatement st=getConnection().prepareStatement(j);
        st.setString(1,firstname);
        st.setString(2, surname);
        st.setString(3, address);
        st.setString(4, email);
        st.setString(5, phoneno);
        st.setString(6, from);
        st.setString(7, to);
        st.setString(8, accomodation);
        st.setString(9,total);
        st.setString(10, idpno);
        
        if(st.executeUpdate()>x){
            JOptionPane.showMessageDialog(null, idpno +" updated successfully");
            
        }
        
       
     }
     catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
}
      public void deletebooking(String idpno) {
         String q="DELETE FROM  booking WHERE idpno=?";
         try{
          int k=0;
                PreparedStatement st=getConnection().prepareStatement(q);
                st.setString(1,idpno);
       if(st.executeUpdate()>k){
               JOptionPane.showMessageDialog(null,idpno+"  customer record deleted successfully");
    }
}
catch(SQLException ex){
    
JOptionPane.showMessageDialog(null,ex.getMessage());
}
}
   public ResultSet getbookings()
 {
         String q="SELECT *FROM  booking";
        
         try{
         Statement st=getConnection().createStatement();
         ResultSet rs=st.executeQuery(q);
        
         
        return rs;
                    
      }
catch(SQLException ex)
{
    
JOptionPane.showMessageDialog(null,ex.getMessage());
 return null;
}
 }
}
