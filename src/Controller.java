public class Controller {
    private View view;
    private ScriptReader sr; 
    private Security security;

    public Controller(View view) {
        this.view = view;
        this.sr = new ScriptReader();
        this.security = new Security();
        start();
    }

    public void start() {
        view.writeToScreen("Hello, welcome to the Online Bakery Store!\n");
        if(security.checkIfSignedUp())
            login();
        else 
            signUp();
    }

    public void signUp(){
        view.writeToScreen("Account not detected, please sign-up", 2);
        String name = view.getInput("Please enter your name:");
        String password = view.getInput("Please enter your password:");
        double funds = view.getInputNum("Please enter the money you are depositing:");
        security.saveUser(name, password, funds);
    }

    public void login(){
        String userAttempt = view.getInput("Please enter your username or type signup to make a new account");
        if(userAttempt.equals("signup")) {
            signUp();
            return;
        }

        if(security.userNameExists(userAttempt)){
            view.writeToScreen("Hello" + userAttempt);
            String passwordAttempt = view.getInput("Please enter your password " + userAttempt);
            if(security.authenticateUserPass(userAttempt, passwordAttempt)){
                view.writeToScreen("Welcome " + userAttempt);
            }
            else{
                //what to do if password in fails 
            }

        } else{
            //write login to try again if username fails 
        }
    }

    public void displayGoods(){

    }

    public void addItemToCard(){

    }


}
