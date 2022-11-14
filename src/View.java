import java.util.*;
import java.util.concurrent.TimeUnit;

public class View {
    private Scanner console;
    private Random generator;

    public View(){
        console = new Scanner(System.in);
        generator = new Random();
    }

    public void writeToScreen(String content){
        System.out.println(content);
    }

    public void writeToScreen(String content, int delay) {
        try{
            System.out.println(content);
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException e){
            System.out.println("Sorry something went wrong trying to write to the screen with a delay");
        }
    }

    public String getInput(String question){
        System.out.println(question);
        String input = console.nextLine();
        return input;
    }

    public double getInputNum(String question){
        System.out.println(question);
        String input = console.nextLine();
        return Double.parseDouble(input);
    }

}