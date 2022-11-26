import java.util.Random;
import Decorator.CandyDecorator;
import Decorator.FreshCreamDecorator;
import Decorator.FruitDecorator;
import Decorator.IcingDecorator;
import Decorator.SprinkleDecorator;
import Factory.*;
import Observer.Customer;
import Observer.StoreObservable;

/*
 * The controller class will manage the flow and of the application 
 * It will be the intermediary between view, models, and other backend related logic
 */
public class Controller {
    private View view;
    private Security security;
    private CartManager cm;

    /*
     * For convienience, controller should not have these as instance variables
     * they are specific to the client and should be dynamically accessed from the Security and CartManager
     */
    private Cart currentCart;
    private String currentUser;
    private StoreObservable onlineBakery = new StoreObservable(); 
    private Random randI; 
    private int myRandInt; 

    public Controller(View view) {
        this.view = view;
        this.security = new Security();
        this.cm = CartManager.getInstance();
        start();
    }

    public void start() {
        view.writeToScreen("Hello, welcome to the Online Bakery Store!\n");
        if(security.checkIfSignedUp())
            login();
        else{ 
            signUp();
        }
        newsletter(); 
        this.currentUser = security.getUser();
        this.currentCart = cm.setUpCart(currentUser);
        randI = new Random(); 

        while(true){
            displayMenu();
            myRandInt = randI.nextInt(4) + 1;
            if(myRandInt == 1)
                giveCoupon();
        }
    }

    public void signUp(){
        view.writeToScreen("Account not detected, please sign-up", 2);
        String name = view.getInput("Please enter your name:");
        String password = view.getInput("Please enter your password:");
        double funds = view.getInputNum("Please enter the money you are depositing:");
        security.saveUser(name, password, funds);
        security.setUser(name);
    }
    public void newsletter(){ 
        final int YES = 1, NO = 2;
        int input = (int)view.getInputNum("\nWould you like to sign up for our newsletter? \n" +
                " 1) Yes\n" + 
                " 2) No\n");
        if(input == YES){
            Customer currentCustomer = new Customer(security.getUser());
            onlineBakery.addSubscriber(currentCustomer);
        }
        else if(input == NO){
            return;
        }
    } 

    public void giveCoupon(){ 
        onlineBakery.setDiscount(10);
    }
    
    public void login(){
        String userAttempt = view.getInput("Please enter your username or type signup to make a new account");
        if(userAttempt.equals("signup")) {
            signUp();
            return;
        }

        if(security.userNameExists(userAttempt)){
            view.writeToScreen("\nHello " + userAttempt);
            String passwordAttempt = view.getInput("Please enter your password: ");
            if(security.authenticateUserPass(userAttempt, passwordAttempt)){
                view.writeToScreen("\nWelcome " + userAttempt);
                security.setUser(userAttempt);
            }
            else{
                //handle if password fails here
            }
        } else{
            //write login to try again if username fails 
        }
    }

    public void displayMenu(){
        final int ADD_ITEM = 1, REMOVE_ITEM = 2, VIEW_CART = 3, CHECKOUT = 4;

        int input = (int)view.getInputNum( "\nSelect an option: \n" +
                "  1) Add Item\n" +
                "  2) Remove Item\n" +
                "  3) View Cart\n" +
                "  4) Checkout\n ");

        //if input is not between 1 and 4 ask again...
        if(input == ADD_ITEM){
            showItemMenu();
        } else if (input == REMOVE_ITEM) {
            showRemoveMenu();
        } else if (input == VIEW_CART) {
            showCartMenu();
        }else if (input == CHECKOUT) {
            showCheckoutMenu();
        } else {
            view.writeToScreen("Please enter a number between 1-4");
            displayMenu();
        }
    }

     public void showItemMenu(){

        int input = (int)view.getInputNum("\nSelect an item option: \n"+
        "1) Cookies\n"+"2) Croissants\n"+"3) Donuts\n"+"4) Cake\n");
        final BakeryFactory BF = new BakeryFactory();

        IItem currPicked = BF.getItem("Cookies"); 

        String[] inputOptions = BakeryModel.staticItemOfferings;
        //InputOptions array 0, 1, 2, 3, 4, 5,

        if(input == 4){
            //Size
            view.writeToScreen("1) 6in Cake\n"+"2) 9in Cake\n");
            input = (int)view.getInputNum("What size of the cake would you like?");
            
            //6in
            if(input == 1)
                currPicked = BF.getItem(inputOptions[4]);
            //9in
            if(input == 2)
                currPicked = BF.getItem(inputOptions[5]);

            
            input = (int)view.getInputNum("\nWould you like to decorate your cake? \n1) yes\n2) no ");
            if(input==1){
                Cake cake = (Cake) currPicked;
                view.writeToScreen("\n");
                do {
                    //Decorations
                    view.writeToScreen("1) Fruit\n2) Candy\n3) Sprinkles\n4) Fresh Cream\n5) Icing\n6.(Pick this when Done)\n");
                    input = (int)view.getInputNum("Pick any toppings you want.");
    
                    if(input == 1) {
                        cake = new FruitDecorator(cake);
                    }
                    else if(input == 2) {
                        cake = new CandyDecorator(cake);
                    }
                    else if(input == 3) {
                        cake = new SprinkleDecorator(cake);
                    }
                    else if(input == 4) {
                        cake = new FreshCreamDecorator(cake);
                    }
                    else if(input == 5) {
                        cake = new IcingDecorator(cake);
                    }
                    else {
                        currPicked = (IItem) cake;
                        break;
                    }
                    view.writeToScreen("Current list of toppings: " + cake.getToppingList());
                } while (input != 6);
                currPicked = cake;
                view.writeToScreen("\n"+cake.getToppingList());

            }
        }
        else{
            currPicked = BF.getItem(inputOptions[input-1]);
        }

        view.writeToScreen("\n"+currPicked.getProductName() + " has been added to cart\n");
        currentCart.addToCart(currPicked);
    }


    public void showRemoveMenu(){
        showCartMenu();
        int input = (int)view.getInputNum("\nSelect an item to remove from cart: \n");
        
        try{
            IItem item = currentCart.getItem(input);
            currentCart.removeFromCart(item, currentCart.getCartIterator().createBakeryIterator());
            System.out.println("Removed " + item.getProductName() + " from your cart:");
            showCartMenu();

        } catch(IndexOutOfBoundsException e){
            view.writeToScreen("\nItem does not exist, please try again\n");
        }

    }

    public void showCartMenu(){
        view.writeToScreen("\n-------------Cart--------------\n");
        currentCart.showCart(currentCart.getCartIterator().createBakeryIterator());
        view.writeToScreen("\n-------------Cart--------------\n");
    }

    public void showCheckoutMenu(){
        view.writeToScreen("to do: showCheckoutMenu");
    }


}
