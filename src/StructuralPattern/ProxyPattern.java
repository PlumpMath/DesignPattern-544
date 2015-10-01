package StructuralPattern;

// real subject
class VirtualMachine {
    public void execute(){
        System.out.println("virtual machine executing!");
    }
}

// proxy
class VirtualMachineManager{
    private VirtualMachine virtualMachine;

    public VirtualMachineManager() {
        virtualMachine = new VirtualMachine();
    }

    private void AllocatedVirtualMachine(){
        System.out.println("Allocate virtual machine");
    }

    private void DeletedVirtualMachine(){
        System.out.println("Deleted virtual machine");
    }

    public void UsingVirtualMachine(){
        AllocatedVirtualMachine();
        virtualMachine.execute();
        DeletedVirtualMachine();
    }
}


public class ProxyPattern {
    public static void main(String[] args) {
        System.out.println("Proxy Pattern!");

        VirtualMachineManager virtualMachineManager = new VirtualMachineManager();

        virtualMachineManager.UsingVirtualMachine();
    }
}
