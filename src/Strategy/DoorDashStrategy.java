package Strategy;

public class DoorDashStrategy implements DeliveryStrategy{
    @Override
    public String deliver(String cart, String address) {
       return "Doordasher delivered: " + cart + "\nto "+address;
    }
}
