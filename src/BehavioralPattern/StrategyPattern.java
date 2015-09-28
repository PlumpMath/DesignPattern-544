package BehavioralPattern;

interface Strategy{
    void execute();
}

class BubbleSort implements Strategy{
    @Override
    public void execute() {
        System.out.println("Using Bubble Sort!");
    }
}

class QuickSort implements Strategy{
    @Override
    public void execute() {
        System.out.println("Using Quick Sort!");
    }
}

class Context{
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.execute();
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        System.out.println("Strategy Pattern!");

        Context context;

        context = new Context(new BubbleSort());
        context.execute();

        context = new Context(new QuickSort());
        context.execute();
    }
}
