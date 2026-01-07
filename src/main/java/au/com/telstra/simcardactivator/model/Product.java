package au.com.telstra.simcardactivator.model;

public class Product {

    private String iccid;
    private String customerEmail;

    public Product () {}

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "iccid='" + iccid + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
