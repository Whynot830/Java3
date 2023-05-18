package Prototype;

public class Ryzen7950X extends CPU {

    public Ryzen7950X() {
        type = "RYZEN";
    }
    @Override
    public void execute() {
        System.out.println("Instruction was executed by AMD Ryzen 7950X");
    }
}
