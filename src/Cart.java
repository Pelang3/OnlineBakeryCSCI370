import Factory.IItem;
import java.util.ArrayList;
import java.util.ListIterator;

class Cart {

    private int cartID;
    private int totalItems;
    private double totalAmount;
    private double payableAmount;
    private double tax;
    private ArrayList<IItem> items;

    private boolean checkedOut;
    private String user; 

    String coupon;
    private double discount;

    Cart(int cartID, String user) {
        this.items = new ArrayList<IItem>();
        this.coupon = "";
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;
        this.totalItems = 0;
        this.cartID = cartID;
        this.checkedOut = false;
        this.user = user;
    }

    public void addToCart(IItem item) {
        this.items.add(item);
        updateTotalItems();
    }

    public void showCart() {
        System.out.println("Items In Cart:");
        for (IItem item : items) {
            System.out.println(item);
        }

        updateTotalItems();
        System.out.println("Item Count: " + totalItems);
        System.out.print("\n");
    }

    public void removeFromCart(IItem i) {
        for (IItem item : items) {
            if (item.getProductName().equals(i.getProductName())) {
                this.items.remove(i);
                totalItems = totalItems-1;
                break;
            }
        }
    }

    public double getTotalAmount() {
        ListIterator<IItem> iterator = items.listIterator();
        this.totalAmount = 0;
        while(iterator.hasNext()) {
            IItem item3 = iterator.next();
            this.totalAmount = this.totalAmount + (item3.getUnitPrice());
        }
        return this.totalAmount;
    }

    /*public void applyCoupon(String coupon) {
        this.coupon = coupon;
        if (coupon.equals("IND10")) {
            this.discount = this.getTotalAmount() * (0.1);
            this.totalAmount = this.totalAmount - this.discount;
        } else {
            this.totalAmount = this.totalAmount;
        }
    }*/
    private double getPayableAmount() {
        this.payableAmount = 0;
        this.tax = this.totalAmount * (0.8625); //updateTax(); //(8.875);
        this.payableAmount = this.totalAmount + this.tax;
        return this.payableAmount;
    }

    private void updateTotalItems() {
        totalItems = totalItems + 1;
    }

    public void printInvoice() {
        ListIterator<IItem> iterator= items.listIterator();
        while(iterator.hasNext()) {
            IItem item4 = iterator.next();
            System.out.print(item4.getProductName() + "\t");
            System.out.print(item4.getUnitPrice() + "\t");
            System.out.println(item4.getUnitPrice());
        }
        System.out.println("\t\t\t" + "Total     : " + this.getTotalAmount());
        //this.applyCoupon(this.coupon);
        //System.out.println("\t\t\t" + "Discount  : " + this.discount);
        this.getPayableAmount();
        System.out.println("\t\t\t" + "Tax       : " + this.tax);
        System.out.println("\t\t\t" + "Total     : " + this.getPayableAmount());
        System.out.println("\t\t\t" + "Item Count: " + this.totalItems);
        System.out.println();
    }

    public int getCartID(){
        return this.cartID;
    }

    public String getUser(){
        return this.user;
    }

    public int getTotalItems(){
        return this.totalItems;
    }

    public void setCheckedOut(){
        this.checkedOut = true;
    }

}



