package BehavioralPattern;

import java.util.HashMap;
import java.util.Map;

class Mediator{
    private Map<Integer, Colleague> ColleagueDictionary = new HashMap<>();

    public void operation(int who, String string){
        Colleague colleague = ColleagueDictionary.get(who);
        colleague.ReceiveMessage(string);
    }

    public void registered(int who, Colleague colleague){
        ColleagueDictionary.put(who, colleague);
        colleague.setMediator(this);
    }
}


class Colleague {

    private Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void SendMessage(int toWho, String string) {
        System.out.println("User : " + this.hashCode() + " send message to " + toWho);
        mediator.operation(toWho,string);
    }

    public void ReceiveMessage(String string) {
        System.out.println("User : " + this.hashCode() + " receive message " + string);
    }
}


public class MediatorPattern {
    public static void main(String[] args) {
        System.out.println("Mediator Pattern!");

        Mediator mediator = new Mediator();
        Colleague colleagueA = new Colleague();
        Colleague colleagueB = new Colleague();

        mediator.registered(1, colleagueA);
        mediator.registered(2, colleagueB);

        colleagueA.SendMessage(2, "Hi 2");
        colleagueB.SendMessage(1, "Hi 1");
    }
}
