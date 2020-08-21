package sample;

public class MySingletonUser {

    public String useSingleton() {
        MySingleton mySingleton = MySingleton.getInstance();
        return mySingleton.doSomething();
    }
}