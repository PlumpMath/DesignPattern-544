package StructuralPattern;

// define the method which client wants to use
interface Target{
    void request();
}

// wrap the original method to the method which client wants to use to the method in the interface
class Adapter implements Target{

    private Adaptee adaptee;

    @Override
    public void request() {
        System.out.println("Calling Adaptee's real request!");
        adaptee.realRequest();
    }

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}

// the original method
class Adaptee {
    public void realRequest(){
        System.out.println("This is real request from Adaptee!");
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        System.out.println("Adapter Pattern!");

        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);

        target.request();
    }
}
