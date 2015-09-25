package BehavioralPattern;

import java.util.ArrayList;
import java.util.List;

// The command interface
interface Command{
    void execute();
}


// The invoker
class Trader{
    public List<Command> getHistory() {
        return history;
    }

    private List<Command> history = new ArrayList<>();

    public void storeAndExecute(Command cmd){
        this.history.add(cmd);
        cmd.execute();
    }
}


// The receiver
class TradePlatform{
    public void buy(){
        System.out.println("Buy Stock!");
    }

    public void sale(){
        System.out.println("Sale Stock!");
    }
}

// The command for sale stock
class SaleStock implements Command{
    private TradePlatform tradePlatform;

    public SaleStock(TradePlatform tradePlatform) {
        this.tradePlatform = tradePlatform;
    }

    @Override
    public void execute() {
        this.tradePlatform.sale();
    }
}

// The command for buy stock
class BuyStock implements Command{
    private TradePlatform tradePlatform;

    public BuyStock(TradePlatform tradePlatform) {
        this.tradePlatform = tradePlatform;
    }

    @Override
    public void execute() {
        this.tradePlatform.buy();
    }
}


public class CommandPattern {
    public static void main(String[] args) {
        System.out.println("Command Pattern!");

        Trader trader = new Trader();
        TradePlatform tradePlatform = new TradePlatform();
        Command saleCommand = new SaleStock(tradePlatform);
        Command buyCommand = new BuyStock(tradePlatform);

        for (int i = 0; i < 10 ; i++){
            if(i % 2 == 0){
                trader.storeAndExecute(buyCommand);
            }
            else {
                trader.storeAndExecute(saleCommand);
            }
        }

        System.out.println("Command execution history");
        for (Command item : trader.getHistory()) {
            System.out.println(item.getClass().getName());
        }
    }
}
