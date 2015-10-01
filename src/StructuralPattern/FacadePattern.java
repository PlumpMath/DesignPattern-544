package StructuralPattern;

// subsystem
class CPU {
    public void execute() {
        System.out.println("CPU executing");
    }
}

// subsystem
class Memory {
    public void load() {
        System.out.println("Memory loading");
    }
}

// subsystem
class HardDrive{
    public void read() {
        System.out.println("HardDrive reading");
    }
}

// subsystem
class Bios{
    public void launch() {
        System.out.println("Computer launching");
    }
}

// Facade
class Computer{
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private Bios bios;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
        bios = new Bios();
    }

    public void launchComputer(){
        bios.launch();
        hardDrive.read();
    }

    public void executeTask(){
        memory.load();
        cpu.execute();
    }

}

public class FacadePattern {
    public static void main(String[] args) {
        System.out.println("Facade Pattern!");

        Computer computer = new Computer();
        computer.launchComputer();
        computer.executeTask();
    }
}
