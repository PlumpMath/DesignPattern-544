package CreatePattern;

//Product
interface CreditCardPaymentServiceProvider {
    void pay();
}

interface EWalletPaymentServiceProvider {
    void pay();
}

class PayPalPro implements CreditCardPaymentServiceProvider {
    @Override
    public void pay() {
        System.out.println("Pay Credit Card With PayPalPro in US");
    }
}

class UniPay implements CreditCardPaymentServiceProvider {
    @Override
    public void pay() {
        System.out.println("Pay Credit Card With UniPay in China");
    }
}

class PayPal implements EWalletPaymentServiceProvider {
    @Override
    public void pay() {
        System.out.println("Pay E-Wallet With PayPal in US");
    }
}

class AliPay implements EWalletPaymentServiceProvider {
    @Override
    public void pay() {
        System.out.println("Pay E-Wallet With AliPay in China");
    }
}


//Product Creator
interface ICountryPaymentServiceProviderFactory {
    CreditCardPaymentServiceProvider creditCardPaymentServiceProvider();

    EWalletPaymentServiceProvider eWalletPaymentServiceProvider();
}

class USPaymentServiceProviderFactory implements ICountryPaymentServiceProviderFactory {
    @Override
    public CreditCardPaymentServiceProvider creditCardPaymentServiceProvider() {
        return new PayPalPro();
    }

    @Override
    public EWalletPaymentServiceProvider eWalletPaymentServiceProvider() {
        return new PayPal();
    }
}

class ChinaPaymentServiceProviderFactory implements ICountryPaymentServiceProviderFactory {
    @Override
    public CreditCardPaymentServiceProvider creditCardPaymentServiceProvider() {
        return new UniPay();
    }

    @Override
    public EWalletPaymentServiceProvider eWalletPaymentServiceProvider() {
        return new AliPay();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        System.out.println("Abstract Factory!");

        System.out.println("US Payment implementation!");
        ICountryPaymentServiceProviderFactory usPaymentServiceProviderFactory = new USPaymentServiceProviderFactory();

        CreditCardPaymentServiceProvider usCreditCardPaymentServiceProvider = usPaymentServiceProviderFactory.creditCardPaymentServiceProvider();
        EWalletPaymentServiceProvider usEWalletPaymentServiceProvider = usPaymentServiceProviderFactory.eWalletPaymentServiceProvider();

        usCreditCardPaymentServiceProvider.pay();
        usEWalletPaymentServiceProvider.pay();

        System.out.println("\nChina Payment implementation!");
        ICountryPaymentServiceProviderFactory chinaPaymentServiceProviderFactory = new ChinaPaymentServiceProviderFactory();

        CreditCardPaymentServiceProvider chinaCreditCardPaymentServiceProvider = chinaPaymentServiceProviderFactory.creditCardPaymentServiceProvider();
        EWalletPaymentServiceProvider chinaEWalletPaymentServiceProvider = chinaPaymentServiceProviderFactory.eWalletPaymentServiceProvider();

        chinaCreditCardPaymentServiceProvider.pay();
        chinaEWalletPaymentServiceProvider.pay();
    }
}
