
package bal;

import bean.OrderBean;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class OrderBAL {
   
    
    public ArrayList<OrderBean> getAllOrders(){
        ArrayList<OrderBean> orders=new ArrayList<OrderBean>();
        Connection con = DBConnection.getCon();
        try{
            Statement st = con.createStatement();
            String query="SELECT o.o_id, o.o_date,o.c_id,o.p_id,o.o_qt,o.total,c.c_name, p.p_name \n" +
            "FROM cust_orders o INNER JOIN customer c\n" +
            "ON (o.c_id=c.c_id)\n" +
            "INNER JOIN product p\n" +
            "ON(o.p_id=p.p_id)";
            
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                OrderBean ob=new OrderBean(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getString(7), rs.getString(8));
                orders.add(ob);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in getAllOrders", 0);
        }
        
        return orders;
    }
    public ArrayList<OrderBean> getAllOrders(String name){
        ArrayList<OrderBean> orders=new ArrayList<OrderBean>();
        Connection con = DBConnection.getCon();
        try{
            Statement st = con.createStatement();
            String query="SELECT o.o_id, o.o_date,o.c_id,o.p_id,o.o_qt,o.total,c.c_name, p.p_name \n" +
            "FROM cust_orders o INNER JOIN customer c\n" +
            "ON (o.c_id=c.c_id)\n" +
            "INNER JOIN product p\n" +
            "ON(o.p_id=p.p_id) where c.c_name like '%"+name+"%'";
            
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                OrderBean ob=new OrderBean(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getString(7), rs.getString(8));
                orders.add(ob);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in getAllOrders", 0);
        }
        
        return orders;
    }
    
    public void insertOrders(String o_date,int c_id,int p_id,int o_qt,int total){
        
        int row=0;
        Connection con = DBConnection.getCon();
        try{
            Statement st = con.createStatement();
            String query="INSERT INTO cust_orders(o_date,c_id,p_id,o_qt,total) VALUES ('"+o_date+"',"+c_id+","+p_id+","+o_qt+","+total+")";
            row=st.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error in insertOrders", 0);
        }
        
        
        if(row>0){
            JOptionPane.showMessageDialog(null,"Reocrd Created","insertOrders", 1);
        }else{
            JOptionPane.showMessageDialog(null,"Reocrd not Created","insertOrders", 2);
        }
        
    }
    public void deleteOrder(int id){
        
        
        
        
        Connection con=DBConnection.getCon();

        try {
            Statement stat=con.createStatement();
            int check=stat.executeUpdate("DELETE FROM cust_orders WHERE o_id ="+id);
            
            if(check>0)
                JOptionPane.showMessageDialog(null,"Order Record Deleted");
            else
                JOptionPane.showMessageDialog(null,"Order Record not Deleted");
            
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"Statement in Deleting");
        }
    }
    public void updateOrders(int id,String o_date,int c_id,int p_id,int o_qt,int total){
    
           
            Connection con=DBConnection.getCon();

        try {
            Statement stat=con.createStatement();
            int check=stat.executeUpdate("UPDATE cust_orders SET o_date = '"+o_date+"',c_id= "+c_id+",p_id ="+p_id+",o_qt ="+o_qt+",total="+total+" WHERE o_id="+id);
            
            if(check>0)
                JOptionPane.showMessageDialog(null,"Order Record Updated");
            else
                JOptionPane.showMessageDialog(null,"Order Record not Updated");
            
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"Statement in Updating");
        }
    }
}
