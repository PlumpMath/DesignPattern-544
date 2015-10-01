package StructuralPattern;

interface TestClass {
    void testMethod();
}

class SimpleTestClass implements TestClass {
    @Override
    public void testMethod() {
        System.out.println("Execute Simple test method");
    }
}

class Decorator implements TestClass {

    private TestClass testClass;

    public Decorator(TestClass testClass) {
        this.testClass = testClass;
    }

    @Override
    public void testMethod() {
        testClass.testMethod();
    }
}

class TestClassWithSetupMethod extends Decorator{

    public TestClassWithSetupMethod(TestClass testClass) {
        super(testClass);
    }

    @Override
    public void testMethod() {
        this.SetupMethod();
        super.testMethod();
    }

    private void SetupMethod(){
        System.out.println("Execute Setup Method");
    }
}


class TestClassWithTeardownMethod extends Decorator{
    public TestClassWithTeardownMethod(TestClass testClass) {
        super(testClass);
    }

    @Override
    public void testMethod() {
        super.testMethod();
        this.TeardownMethod();
    }

    private void TeardownMethod(){
        System.out.println("Execute Teardown Method");
    }
}

class TestClassWithSetupAndTeardownMethod extends Decorator{
    public TestClassWithSetupAndTeardownMethod(TestClass testClass) {
        super(testClass);
    }

    @Override
    public void testMethod() {
        this.SetupMethod();
        super.testMethod();
        this.TeardownMethod();
    }

    private void SetupMethod(){
        System.out.println("Execute Setup Method");
    }

    private void TeardownMethod(){
        System.out.println("Execute Teardown Method");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        System.out.println("Decorator Pattern!");

        System.out.println("_____________________________________");
        System.out.println("Simple Test Method");
        TestClass testClass;
        testClass = new SimpleTestClass();
        testClass.testMethod();

        System.out.println("_____________________________________");
        System.out.println("Test Method with Setup Method");
        testClass = new TestClassWithSetupMethod(new SimpleTestClass());
        testClass.testMethod();

        System.out.println("_____________________________________");
        System.out.println("Test Method with Teardown Method");
        testClass = new TestClassWithTeardownMethod(new SimpleTestClass());
        testClass.testMethod();

        System.out.println("_____________________________________");
        System.out.println("Test Method with Setup and Teardown Method");
        testClass = new TestClassWithSetupAndTeardownMethod(new SimpleTestClass());
        testClass.testMethod();

    }
}
