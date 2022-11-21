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

    @Override
    public String getProductName() {
        // TODO Auto-generated method stub
        return "Donut";
    }

    @Override
    public double getUnitPrice() {
        // TODO Auto-generated method stub
        return Price;
    }

}
