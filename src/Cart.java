import Factory.IItem;
import java.util.ArrayList;
import java.util.ListIterator;

class Cart {

    private static int cartID = 0;
    private static int totalItems = 0;
    ArrayList<IItem> item;
    double totalAmount;
    double payableAmount;
    double discount;
    double tax;
    String coupon;
    Cart() {
        this.item = new ArrayList<IItem>();
        this.coupon = "";
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;

    }

    private int updateCartID() {

        return this.cartID = cartID + 1;
    }
    public void addToCart(IItem item) {
        this.item.add(item);
        totalItems = totalItems + item.getQuantity();
    }
    public void showCart() {
        System.out.println("Items In Cart:");
        for (IItem item1 : item) {
            System.out.println(item1);
        }
        System.out.println("Item Count: " + updateTotalItems());
        System.out.print("\n");
    }
    public void removeFromCart(IItem i) {
        for (IItem item2 : item) {
            if (item2.getProductName().equals(i.getProductName())) {
                this.item.remove(i);
                totalItems = totalItems - item2.getQuantity();
                break;
            }
        }
    }
    public double getTotalAmount() {
        ListIterator<IItem> iterator2 = item.listIterator();
        this.totalAmount = 0;
        while(iterator2.hasNext()) {
            IItem item3 = iterator2.next();
            this.totalAmount = this.totalAmount + (item3.getUnitPrice() * item3.getQuantity());
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

    /*public int totalItems() {
        ListIterator<Item> iterator3 = item.listIterator();
        this.totalItems = 0;
        while(iterator3.hasNext()) {
            Item item4 = iterator3.next();
            this.totalItems = this.totalItems + item4.getQuantity();
        }
        return this.totalItems;
    }*/

    private int updateTotalItems() {
        ListIterator<IItem> iterator3 = item.listIterator();
        this.totalItems = 0;
        while(iterator3.hasNext()) {
            IItem item4 = iterator3.next();
            this.totalItems = this.totalItems + item4.getQuantity();
        }
        return this.totalItems;
    }
    public void printInvoice() {
        ListIterator<IItem> iterator4= item.listIterator();
        System.out.println("Cart Number: " + updateCartID());
        while(iterator4.hasNext()) {
            IItem item4 = iterator4.next();
            System.out.print(item4.getProductName() + "\t");
            System.out.print(item4.getQuantity() + "\t");
            System.out.print(item4.getUnitPrice() + "\t");
            System.out.println(item4.getUnitPrice() * item4.getQuantity());
        }
        System.out.println("\t\t\t" + "Total     : " + this.getTotalAmount());
        //this.applyCoupon(this.coupon);
        //System.out.println("\t\t\t" + "Discount  : " + this.discount);
        this.getPayableAmount();
        System.out.println("\t\t\t" + "Tax       : " + this.tax);
        System.out.println("\t\t\t" + "Total     : " + this.getPayableAmount());
        System.out.println("\t\t\t" + "Item Count: " + updateTotalItems());
        System.out.println();
    }
}



