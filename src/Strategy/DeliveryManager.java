package Strategy;

public class DeliveryManager {
    private DeliveryStrategy ds;

    public DeliveryManager(){
        
    }

    public void setDeliveryMethod(DeliveryStrategy newStrategy){
        this.ds = newStrategy;
    }

    public void deliver(String cart, String address){
        ds.deliver(cart, address);
    }

}
