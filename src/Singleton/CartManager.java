package Singleton;
import java.util.ArrayList;

public class CartManager {
    ArrayList<Cart> carts;
    private int idIncrememter;
    private static CartManager instance = new CartManager(); // eagerly loads the singleton

    private CartManager() {
        // private to prevent anyone else from instantiating
        this.carts = new ArrayList<>();
        this.idIncrememter = 0;
    }

    public static CartManager getInstance() {
        return instance;
    }

    public void addNewCart(String user) {
        int cartId = idIncrememter++;
        Cart newCart = new Cart(cartId, user);
        carts.add(newCart);
    }

    public void removeCart(int cartID) {
        for (Cart cart : carts) {
            if (cart.getCartID() == cartID)
                carts.remove(cart);
        }
    }

    public void checkoutCart(int cartID) {
        for (Cart cart : carts) {
            if (cart.getCartID() == cartID)
                cart.setCheckedOut();
        }
    }

    public Cart getUserCart(String user){
        for (Cart cart : carts) {
            if (cart.getUser().equals(user))
                return cart;
        }
        return null;
    }

    public Cart setUpCart(String user){
        Cart cart = getUserCart(user);
        if(cart==null)
            addNewCart(user);
        return getUserCart(user);
    }
    public int getIdIncrememter() {
        return idIncrememter;
    }

}
