package Facade;

public class PC {
    public BootDisk bootDisk;
    MBR mbr;
    OperatingSystem os;
    POST post;
    public PC() {
        bootDisk = new BootDisk(0);
        post = new POST(0);
        mbr = new MBR(0);
        os = new OperatingSystem(0);
    }
    public PC(int code1, int code2, int code3, int code4) {
        bootDisk = new BootDisk(code1);
        post = new POST(code2);
        mbr = new MBR(code3);
        os = new OperatingSystem(code4);

    }
    public void turnOn() {
        bootDisk.bootloaderCheck();
        post.check();
        mbr.moveData();
        os.boot();
    }
}
