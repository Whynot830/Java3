import AbstractFactory.*;
import FactoryMethod.*;
import Builder.*;
import Prototype.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String bl = '\n' + "=".repeat(50);
        System.out.println(bl);
        System.out.println("BUILDER PATTERN\n");
        CpuBuilder cpuBuilder = new CpuBuilder();
        CentralProcessingUnit cpu1 = new CpuBuildDirector().build("tensor");
        cpu1.execute();
        System.out.println();
        PersonalComputer myPc = PersonalComputer
                .newBuilder()
                .setCpu("INTEL 12TH I5 12400F")
                .setMotherboard("MSI B660-A PRO DDR4")
                .setGpu("NVIDIA GEFORCE RTX 2060 12GB")
                .setHdd("WD BLUE 2TB")
                .setSsd("SAMSUNG 980 512GB")
                .setRam("KINGSTON FURY RENEGADE 2x8GB")
                .setPowerSupply("DEEPCOOL PQ650M GOLD 650W")
                .build();
        System.out.print(myPc);
        System.out.println(bl);

        System.out.println("FACTORY METHOD PATTERN\n");
        CPUGenerator cpuGenerator;
        List<CPUGenerator> generatorList = new ArrayList<>();
        generatorList.add(new Snapdragon8Gen2Generator());
        generatorList.add(new TensorG2Generator());
        for (int i = 0; i < generatorList.size(); i++) {
            cpuGenerator = generatorList.get(i);
            cpuGenerator.run();
        }
        System.out.println(bl);

        System.out.println("ABSTRACT FACTORY PATTERN\n");
        CpuFactory cpuFactory = new CpuFactory();
        cpu1 = cpuFactory.create("Tensor");
        CentralProcessingUnit cpu2 = cpuFactory.create("Snapdragon");
        cpu1.execute();
        cpu2.execute();
        System.out.println(bl);

        System.out.println("PROTOTYPE PATTERN");
        ArrayList<CPU> cpus = new ArrayList<>();
        cpus.add(new Ryzen7950X());
        cpus.add(new Intel13900K());
        cpus.add((CPU) cpus.get(0).clone());
        cpus.add((CPU) cpus.get(1).clone());
        for (int i = 0; i < cpus.size(); i++) {
            cpus.get(i).execute();
        }
    }
}