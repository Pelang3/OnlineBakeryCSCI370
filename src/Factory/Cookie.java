package Factory;
public class Cookie implements IItem{
    private final int Price = 2;

    public Cookie(){

    }
    @Override
    public int getPrice() {
        // TODO Auto-generated method stub
        return Price;
    }
    @Override
    public String getProductName() {
        // TODO Auto-generated method stub
        return "Cookie";
    }
    @Override
    public double getUnitPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

}
