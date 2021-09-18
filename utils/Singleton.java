package utils;

public class Singleton {
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

class HungrySingleton{
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}

class LazySingleton{
    private static LazySingleton instance;
    private LazySingleton(){}
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
