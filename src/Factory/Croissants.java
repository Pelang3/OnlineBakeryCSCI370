package Factory;

public class Croissants implements IItem {
    private final int Price = 2;

    public Croissants() {
    }

    @Override
    public int getPrice() {
        return Price;
    }

    @Override
    public String getProductName() {
        return "Croissant";
    }

    @Override
    public double getUnitPrice() {
        return Price;
    }

}
