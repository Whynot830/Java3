package Snapshot;

public class PC {
    private String gpu;
    private String cpu;
    private String motherboard;

    public PC(String gpu, String cpu, String motherboard) {
        this.gpu = gpu;
        this.cpu = cpu;
        this.motherboard = motherboard;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }
    public PCMemento saveState() {
        return new PCMemento(this.gpu, this.cpu, this.motherboard);
    }
    public void restoreState(PCMemento pcMemento) {
        this.gpu = pcMemento.getGpu();
        this.cpu = pcMemento.getCpu();
        this.motherboard = pcMemento.getMotherboard();
    }

    @Override
    public String toString() {
        return "PC{" +
                "gpu='" + gpu + '\'' +
                ", cpu='" + cpu + '\'' +
                ", motherboard='" + motherboard + '\'' +
                '}';
    }
}

