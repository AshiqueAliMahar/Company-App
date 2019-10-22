
package bal;

import bean.ProductBean;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductBAL{
    
    
        
    
    public ArrayList<ProductBean> getAllProducts(){
        ArrayList<ProductBean> products=new ArrayList<ProductBean>();
        Connection con = DBConnection.getCon();
        try{
            Statement st = con.createStatement();
            String query="SELECT p_id,p_name,p_price FROM product";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ProductBean pb=new ProductBean(rs.getInt(1),rs.getString(2),rs.getInt(3));
                products.add(pb);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in getAllProducts", 0);
        }
        
        return products;
    }
    
    
    //
        public ArrayList<ProductBean> getAllProducts(String pname){
            ArrayList<ProductBean> products=new ArrayList<ProductBean>();
            Connection con = DBConnection.getCon();
            try{
                Statement st = con.createStatement();
                String query="SELECT p_id,p_name,p_price FROM product where p_name like '%"+pname+"%'";
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    ProductBean pb=new ProductBean(rs.getInt(1),rs.getString(2),rs.getInt(3));
                    products.add(pb);
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in getAllProducts", 0);
            }
            return products;
        }
    //
    
    
    
    
    public void insertProducts(String name, int price){
        
        int row=0;
        Connection con = DBConnection.getCon();
        try{
            Statement st = con.createStatement();
            String query="INSERT INTO product(p_name,p_price) VALUES ('"+name+"',"+price+")";
            row=st.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in insertProducts", 0);
        }
        
        
        if(row>0){
            JOptionPane.showMessageDialog(null,"Reocrd Created","insertProducts", 1);
        }else{
            JOptionPane.showMessageDialog(null,"Reocrd not Created","insertProducts", 2);
        }
        
    }
    
    
    public void updateProducts(int id,String name, int price){
        
        int row=0;
        Connection con = DBConnection.getCon();
        try{
            Statement st = con.createStatement();
            String query="UPDATE product SET p_name = '"+name+"',p_price = "+price+" WHERE p_id ="+id;
            row=st.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in updateProducts", 0);
        }
        
        
        if(row>0){
            JOptionPane.showMessageDialog(null,"Reocrd updated","updateProducts", 1);
        }else{
            JOptionPane.showMessageDialog(null,"Reocrd not updated","updateProducts", 2);
        }
        
    }
    
    public void deleteProducts(int id){
        
        int row=0;
        Connection con = DBConnection.getCon();
        try{
            Statement st = con.createStatement();
            String query="DELETE FROM product WHERE p_id ="+id;
            row=st.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in deleteProducts", 0);
        }
        
        
        if(row>0){
            JOptionPane.showMessageDialog(null,"Reocrd deleted","deleteProducts", 1);
        }else{
            JOptionPane.showMessageDialog(null,"Reocrd not deleted","deleteProducts", 2);
        }
        
    }
    
}
