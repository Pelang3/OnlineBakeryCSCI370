package Strategy;

public class DoorDashStrategy implements DeliveryStrategy{
    @Override
    public void deliver(String cart, String address) {
        System.out.println("Doordasher delivered: " + cart + "\nto"+address);
    }
}
