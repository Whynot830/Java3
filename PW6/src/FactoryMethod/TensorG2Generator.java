package FactoryMethod;

public class TensorG2Generator extends CPUGenerator {
    @Override
    public CentralProcessingUnit createCpu() {
        System.out.println("Tensor G2 created");
        return new TensorG2();
    }
}
