package sample;

import java.util.Map;

public final class PowerMockStaticFinalClass {

    public PowerMockStaticFinalClass() {
    
    }

    public static String returnString() {
        return "MOCK TEST";
    }

    public static Map returnMap(String key) {
        return (Map) MyFinal.getObjectFromSomewhere(key);
    
    }
}