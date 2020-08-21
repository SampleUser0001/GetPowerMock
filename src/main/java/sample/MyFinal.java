package sample;

import java.util.Map;
import java.util.HashMap;

public final class MyFinal {

    public static Object getObjectFromSomewhere(String key) {
        //return the object
        
        Map<String, String> map = new HashMap<String, String>();
        map.put(key , "hogehoge");
        
        return map;
    }
}
