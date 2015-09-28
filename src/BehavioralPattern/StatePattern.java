package BehavioralPattern;

interface State{
    void behavior();
}

class Approved implements State{
    @Override
    public void behavior() {
        System.out.println("This PO is Approved!");
    }
}

class Reviewed implements State{
    @Override
    public void behavior() {
        System.out.println("This PO is Reviewed");
    }
}

class ContextOfDocumentStates {
    private State state;

    public ContextOfDocumentStates(State state) {
        this.state = state;
    }

    public void change (State state) {
        this.state = state;
    }

    public void behavior () {
        state.behavior();
    }
}

public class StatePattern {

    public static void main(String[] args) {
        System.out.println("State Pattern!");

        ContextOfDocumentStates context = new ContextOfDocumentStates(new Approved());
        context.behavior();

        context.change(new Reviewed());
        context.behavior();
    }
}
