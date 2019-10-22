
package bal;

import bean.CustomerBean;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CustomerBal {
    
    Connection con=null;
    Statement st=null;
    public ArrayList<CustomerBean> selectData(){
        ArrayList<CustomerBean> arrCus=new ArrayList<>();
        con=DBConnection.getCon();
        try {
            st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT c_id,c_name,c_contact,c_address FROM customer");
            while(rs.next()){
                
                CustomerBean ob=new CustomerBean(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
                arrCus.add(ob);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Retrieve Customer Rcord");
        }
        
        
        return arrCus;
        
    }
     public ArrayList<CustomerBean> selectData(String custName){
        ArrayList<CustomerBean> arrCus=new ArrayList<>();
        con=DBConnection.getCon();
        try {
            st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT c_id,c_name,c_contact,c_address FROM customer where c_name like '%"+custName+"%'");
            while(rs.next()){
                
                CustomerBean ob=new CustomerBean(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
                arrCus.add(ob);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Retrieve Customer Rcord");
        }
        
        
        return arrCus;
        
    }
    public void insertCustmr(String c_name,String contct,String address){
        
        try {
            int row=st.executeUpdate("INSERT INTO customer(c_name,c_contact,c_address)VALUES ('"+c_name+"','"+contct+"','"+address+"')");
            if(row>0)
                JOptionPane.showMessageDialog(null, "Customer Data Inserted");
            else
                JOptionPane.showMessageDialog(null, "Customer Data not Inserted");
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Customer Record Inserting");
        }
        
    }
    
    public void deleteCustmr(int c_id){
        
        try {
            int row=st.executeUpdate("DELETE FROM customer WHERE c_id = '"+c_id+"'");
            if(row>0)
                JOptionPane.showMessageDialog(null, "Customer Data Deleted");
            else
                JOptionPane.showMessageDialog(null, "Customer Data not Deleted");
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Customer Record Deletion");
        }
        
    }
    
    public void updatCustmr(int c_id,String c_name,String contct,String address){
        
        try {
            int row=st.executeUpdate("UPDATE customer SET c_name = '"+c_name+"',`c_contact` = '"+contct+"',`c_address` = '"+address+"'WHERE `c_id` = '"+c_id+"';");
            if(row>0)
                JOptionPane.showMessageDialog(null, "Customer Data Updated");
            else
                JOptionPane.showMessageDialog(null, "Customer Data not Updated");
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Customer Record Updating");
        }
        
    }
    
}
