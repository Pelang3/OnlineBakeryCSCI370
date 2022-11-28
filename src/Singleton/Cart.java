package Singleton;

import Factory.IItem;
import Iterator.BakeryIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {

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


    public void showCart(Iterator<IItem> iterator) {
        int num = 1;
        System.out.println("Items in your cart:");
        while (iterator.hasNext()) {
            IItem i = (IItem) iterator.next();
            System.out.print(num+") "+i.getProductName());
            if (iterator.hasNext() != false) {
                System.out.print(" $" + String.format("%.2f",i.getUnitPrice())+ "\n");
            } else {
                System.out.print(" $" + String.format("%.2f",i.getUnitPrice())+ "\n");
            }
            num++;
        }
        System.out.print("\n");
        System.out.print("Item Count: " + totalItems);
        System.out.print("\n");
    }

    public void removeFromCart(IItem i, Iterator<IItem> iterator) {
        while (iterator.hasNext()) {
            IItem j = (IItem) iterator.next();
            if (j.equals(i)) {
                iterator.remove();
                totalItems = totalItems - 1;
                return;
            } 
        }
    }

    public IItem getItem(int i){
        return items.get(i-1);
    }

    public double getTotalAmount(Iterator<IItem> iterator) {

        this.totalAmount = 0;
        while (iterator.hasNext()) {
            IItem i = (IItem) iterator.next();
            this.totalAmount += i.getUnitPrice();
        }

        return this.totalAmount;
    }

    /*
     * public void applyCoupon(String coupon) {
     * this.coupon = coupon;
     * if (coupon.equals("IND10")) {
     * this.discount = this.getTotalAmount() * (0.1);
     * this.totalAmount = this.totalAmount - this.discount;
     * } else {
     * this.totalAmount = this.totalAmount;
     * }
     * }
     */
    
    // public double getPayableAmount() {
    //     this.payableAmount = 0;
    //     double taxed = this.totalAmount * 0.08875;
    //     this.tax = taxed;
    //     System.out.println("\t\t\t" + "Tax : " + tax);
    //     this.payableAmount = (this.totalAmount + taxed);
    //     return this.payableAmount;
    // }

    private void updateTotalItems() {
        totalItems = totalItems + 1;
    }

    // public void printInvoice(Iterator<IItem> iterator) {
    //     // before tax and coupons
    //     double BeforeTAC = getTotalAmount(iterator);
    //     System.out.println("\n\t\t\t" + "Total : " + BeforeTAC);
    //     // this.applyCoupon(this.coupon);
    //     // System.out.println("\t\t\t" + "Discount : " + this.discount);
    //     System.out.println("\t\t\t" + "Total : " + this.getPayableAmount());
    //     System.out.println("\t\t\t" + "Item Count: " + this.totalItems);
    //     System.out.println();
    // }

    public String getCartString(Iterator<IItem> iterator){
            String output = "";
            while (iterator.hasNext()) {
                IItem i = (IItem) iterator.next();
                output+="\n"+i.getProductName() + " $" + String.format("%.2f",i.getUnitPrice());
            }
            return output;
    }

    public int getCartID() {
        return this.cartID;
    }

    public String getUser() {
        return this.user;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public void setCheckedOut() {
        this.checkedOut = true;
    }

    public BakeryIterator getCartIterator() {
        return new CartIterator();
    }

    private class CartIterator implements BakeryIterator {
        @Override
        public Iterator<IItem> createBakeryIterator() {
            return items.iterator();
        }
    }

}
