package Strategy;

public class UPSMailStrategy implements DeliveryStrategy{
    @Override
    public String deliver(String cart, String address) {
        return "UPS delivered: " + cart + "\nto "+address;
    }
}
