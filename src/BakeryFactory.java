import Factory.*;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

public class BakeryFactory {
    //Bakery Map because conditionals stinky
    private static final Map<String, IItem> Bakery_Creator_Map = ImmutableMap.of(
        "Cookies", new Cookie(),
        "Donuts", new Donuts(),
        "Croissants", new Croissants(),
        "6inCake", new Cake(6),
        "9inCake", new Cake(9) 
    );

    private BakeryFactory(){//default constructor
    }

    public IItem getItem(String type){
        if(Bakery_Creator_Map.containsKey(type)){
            return Bakery_Creator_Map.get(type);
        }
        throw new UnsupportedOperationException();
    }
}

