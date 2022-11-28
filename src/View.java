/*
 * The view class is what will be handle displaying 
 * and recieving input to the user as well as recieving input 
 */
import java.util.*;
import java.util.concurrent.TimeUnit;

public class View {
    private Scanner console;

    public View(){
        console = new Scanner(System.in);
    }

    //write a string message to the console
    public void writeToScreen(String content){
        System.out.println(content);
    }

    //write a string message to console with a delay 
    public void writeToScreen(String content, int delay) {
        try{
            System.out.println(content);
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException e){
            System.out.println("Sorry something went wrong trying to write to the screen with a delay");
        }
    }

    //get string user input with a question string preceding it
    public String getInput(String question){
        System.out.println(question);
        String input = console.nextLine();
        return input;
    }

    //get a double user input with a question string preceding it
    public double getInputNum(String question){
        try{
            System.out.println(question);
            String input = console.nextLine();
            return Double.parseDouble(input);
        } catch(NumberFormatException e){
            System.out.println("Please enter a valid number response ex. 1");
            return getInputNum(question);
        }
    }

}