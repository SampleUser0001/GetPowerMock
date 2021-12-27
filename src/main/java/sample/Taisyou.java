package sample;

public class Taisyou {

    public String search() {
        Util util = new Util();

        return util.get();
    }
    
    /**
     * 自分自身のprivateメソッドを呼ぶ。コレ自体はpublic。
     */
    public String callPrivatePrint() {
        return print();
    }
    
    /**
     * 自分自身のprivateメソッドを呼ぶ。コレ自体もprivate。
     */
    private String callPrivatePrint_meToo() {
        return print();
    }

    /**
     * privateメソッド。あちこちから呼ばれる。
     */
    private String print() {
        return "いやいやそんなはずは";
    }
    
    /**
     * public staticメソッド。
     */
    public static String staticMethod() {
        return "staticメソッドのMockができていない";
    }

}