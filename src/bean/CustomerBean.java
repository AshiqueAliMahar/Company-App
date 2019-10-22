
package bean;

public class CustomerBean {
    private int Id;
    private String Name;
    private String Contact;
    private String Address;

    public CustomerBean(int Id, String Name, String Contact, String Address) {
        this.Id = Id;
        this.Name = Name;
        this.Contact = Contact;
        this.Address = Address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return Name+"-"+Id ;
    }
    
    
    
}
