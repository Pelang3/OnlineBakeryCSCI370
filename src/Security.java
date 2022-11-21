/*
 * This class will handle all account login logic 
 * Could add a User class 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Security {
    BufferedReader reader;
    BufferedWriter writer;

    //this would be provided from client in it's request but b/c its not a full app,
    //assuming lastUser the client sending the req with a cookie field containing it's id
    String lastUser; 
    
    public Security(){

    }

    public boolean checkIfSignedUp(){
        try{
            reader = new BufferedReader(new FileReader("src/Database/loginInfo.txt"));
            reader.close();
            return true;
        } catch(IOException e){
            return false;
        }
    }

    public void saveUser(String name, String password, double funds){
        try{
            writer = new BufferedWriter(new FileWriter("src/Database/loginInfo.txt"));
            writer.write(name + "\n" + password + "\n"+ funds);
            writer.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }

    public boolean userNameExists(String attemptedName){
        //toDO
        return true;
    }

    public boolean authenticateUserPass(String attemptedName, String attemptedPassword){
        //toDO
        return true;
    }

    public void setUser(String user){
        this.lastUser = user;
    }
    
    public String getUser(){
        return this.lastUser;
    }

}
