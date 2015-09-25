package CreatePattern;


class SingletonSample {

    private static SingletonSample singleton;

    private SingletonSample(){

    }

    public static SingletonSample getInstance(){
        if(singleton == null){
            singleton = new SingletonSample();
        }

        return singleton;
    }
}

public class Singleton {
    public static void main(String[] args) {
        System.out.println("Singleton!");

        SingletonSample singletonA = SingletonSample.getInstance();
        SingletonSample singletonB = SingletonSample.getInstance();

        System.out.println(singletonA);
        System.out.println(singletonB);

    }
}