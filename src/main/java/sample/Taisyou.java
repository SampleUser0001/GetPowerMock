package sample;

public class Taisyou {

    public String search() {
        Util util = new Util();

        return util.get();
    }
    
    public String callPrivatePrint() {
        return print();
    }
    
    private String callPrivatePrint_meToo() {
        return print();
    }

    private String print() {
        return "いやいやそんなはずは";
    }
    
    public static String staticMethod() {
        return "staticメソッドのMockができていない";
    }

}