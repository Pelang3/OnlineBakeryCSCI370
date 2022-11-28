package Factory;
public class Cookie implements IItem{
    private final int Price = 1;

    public Cookie(){

    }
    
    @Override
    public int getPrice() {
        return Price;
    }
    @Override
    public String getProductName() {
        return "Cookie";
    }

    @Override
    public double getUnitPrice() {
        return Price;
    }

}
