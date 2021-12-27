package sample;

import sample.bean.Bean;

public class Taisyou2 {
    
    private void editBean(Bean bean) {
        bean.setValue(getHogeValue("piyo"));
    }
    
    private static String getHogeValue(String piyo) {
        return "hoge";
    }
    
    public static String callPrivateStatic() {
        return getHogeValue("piyo");
    }
}