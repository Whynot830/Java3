package Prototype;

public class Intel13900K extends CPU {

    public Intel13900K() {
        type = "INTEL";
    }
    @Override
    public void execute() {
        System.out.println("Instruction was executed by Intel I9-13900K");
    }
}
