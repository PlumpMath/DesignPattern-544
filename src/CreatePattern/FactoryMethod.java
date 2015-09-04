package CreatePattern;

//PSP
interface PaymentServiceProvider {
    void pay();
}

class Bibit implements PaymentServiceProvider {
    @Override
    public void pay() {
        System.out.println("Pay with Bibit!");
    }
}

class Adyen implements PaymentServiceProvider {
    @Override
    public void pay() {
        System.out.println("Pay with Adyen!");
    }
}

//PSP Factory
interface IPaymentServiceProviderFactory {
    PaymentServiceProvider producePaymentServiceProvider();
}

class BibitFactory implements IPaymentServiceProviderFactory {
    @Override
    public PaymentServiceProvider producePaymentServiceProvider() {
        return new Bibit();
    }
}

class AdyenFactory implements IPaymentServiceProviderFactory {
    @Override
    public PaymentServiceProvider producePaymentServiceProvider() {
        return new Adyen();
    }
}


public class FactoryMethod {
    public static void main(String[] args) {
        System.out.println("Factory Method!");

        System.out.println("Bibit CreditCard implementation!");
        IPaymentServiceProviderFactory bibitFactory = new BibitFactory();
        PaymentServiceProvider bibit = bibitFactory.producePaymentServiceProvider();
        bibit.pay();

        System.out.println("\nAdyen CreditCard implementation!");
        IPaymentServiceProviderFactory adyenFactory = new AdyenFactory();
        PaymentServiceProvider adyen = adyenFactory.producePaymentServiceProvider();
        adyen.pay();
    }
}


