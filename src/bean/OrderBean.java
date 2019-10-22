
package bean;


public class OrderBean {
    
    private int Id;
    private String Date;
    private int cid;
    private int pid;
    private int quantity;
    private int total;
    private String c_name;
    private String p_name;

    public OrderBean(int Id, String Date, int cid, int pid, int quantity, int total, String c_name, String p_name) {
        this.Id = Id;
        this.Date = Date;
        this.cid = cid;
        this.pid = pid;
        this.quantity = quantity;
        this.total = total;
        this.c_name = c_name;
        this.p_name = p_name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    
    
   

    
    
    
    
}
