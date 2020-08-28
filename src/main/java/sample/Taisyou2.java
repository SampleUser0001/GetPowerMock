package sample;

import sample.bean.Bean;

public class Taisyou2 {
    
    private void editBean(Bean bean) {
        bean.setValue(getHogeValue());
    }
    
    private static String getHogeValue() {
        return "hoge";
    }
    
    public static String callPrivateStatic() {
        return getHogeValue();
    }
}