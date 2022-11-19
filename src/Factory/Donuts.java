package Factory;

public class Donuts implements IItem{
    private final int Price = 2;

    public Donuts(){
    }
    
    @Override
    public int getPrice() {
        // TODO Auto-generated method stub
        return Price;
    }
}
