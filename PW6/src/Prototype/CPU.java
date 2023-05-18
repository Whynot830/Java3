package Prototype;

public abstract class CPU implements Cloneable {
    protected String type;
    private int clockSpeed;
    private int cores;
    private int threads;
    private int lithographyProcess;
    public abstract void execute();

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public void setLithographyProcess(int lithographyProcess) {
        this.lithographyProcess = lithographyProcess;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    };
}
