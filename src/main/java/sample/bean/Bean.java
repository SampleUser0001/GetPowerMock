package sample.bean;

public class Bean {
    private String value;

    public Bean() {
        this.value = "";
    }
    
    public void setValue(String s) {
        this.value = s;
    }
    
    public String getValue() {
        return value;
    }
    
}