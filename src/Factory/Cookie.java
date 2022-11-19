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
}
