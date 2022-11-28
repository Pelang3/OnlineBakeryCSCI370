package Strategy;

public class DeliveryManager {
    private DeliveryStrategy ds;

    public DeliveryManager(){
        
    }

    public void setDeliveryMethod(DeliveryStrategy newStrategy){
        this.ds = newStrategy;
    }

    public String deliver(String cart, String address){
        return ds.deliver(cart, address);
    }

}
