package Snapshot;

public class PCMemento {
    private final String gpu;
    private final String cpu;
    private final String motherboard;

    public PCMemento(String gpu, String cpu, String motherboard) {
        this.gpu = gpu;
        this.cpu = cpu;
        this.motherboard = motherboard;
    }

    public String getGpu() {
        return gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    @Override
    public String toString() {
        return "PCMemento{" +
                "gpu='" + gpu + '\'' +
                ", cpu='" + cpu + '\'' +
                ", motherboard='" + motherboard + '\'' +
                '}';
    }
}
