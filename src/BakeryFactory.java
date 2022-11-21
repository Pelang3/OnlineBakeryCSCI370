import Factory.*;
import java.util.Map;

public class BakeryFactory {
    //Bakery Map because conditionals stinky
    private static final Map<String, IItem> Bakery_Creator_Map = Map.of(
        "Cookies", new Cookie(),
        "Donuts", new Donuts(),
        "Croissants", new Croissants(),
        "6inCake", new Cake(6),
        "9inCake", new Cake(9) 
    );

    BakeryFactory(){//default constructor
    }
    public IItem getItem(String type){
        if(Bakery_Creator_Map.containsKey(type)){
            return Bakery_Creator_Map.get(type);
        }
        throw new UnsupportedOperationException();
    }
}

