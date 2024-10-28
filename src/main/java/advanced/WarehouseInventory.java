package advanced;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WarehouseInventory {

    public Map<String,ArrayList<String>> warehouse = new HashMap<>();

    public Collection<String> getLocations(){
        // perform a check that there are any location
        return this.warehouse.keySet();
    }




}
