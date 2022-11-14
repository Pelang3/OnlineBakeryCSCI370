import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Security {
    BufferedReader reader;
    BufferedWriter writer;
    
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
        
        return true;
    }

    public boolean authenticateUserPass(String attemptedName, String attemptedPassword){
        
        return true;
    }

}
