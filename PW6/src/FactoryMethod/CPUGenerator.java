package FactoryMethod;

public abstract class CPUGenerator {
    public abstract CentralProcessingUnit createCpu();
    public void run() {
        CentralProcessingUnit cpu = createCpu();
        cpu.execute();
    }

}
