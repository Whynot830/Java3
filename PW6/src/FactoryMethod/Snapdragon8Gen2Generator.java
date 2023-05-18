package FactoryMethod;

public class Snapdragon8Gen2Generator extends CPUGenerator {
    @Override
    public CentralProcessingUnit createCpu() {
        System.out.println("Snapdragon 8 Gen 1 created");
        return new Snapdragon8Gen2();
    }
}
