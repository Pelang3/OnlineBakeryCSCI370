package Strategy;

public class UPSMailStrategy implements DeliveryStrategy{
    @Override
    public void deliver(String cart, String address) {
        System.out.println("UPS delivered:" + cart + "\nto "+address);
    }
}
