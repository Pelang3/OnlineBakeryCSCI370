package Factory;

public class Croissants implements IItem {
    private final int Price = 2;

    public Croissants() {
    }

    @Override
    public int getPrice() {
        // TODO Auto-generated method stub
        return Price;
    }

    @Override
    public String getProductName() {
        // TODO Auto-generated method stub
        return "Croissant";
    }

    @Override
    public double getUnitPrice() {
        // TODO Auto-generated method stub
        return Price;
    }

}
