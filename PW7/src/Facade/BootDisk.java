package Facade;

public class BootDisk extends Component {
    public BootDisk() {
        super();
    }

    public BootDisk(int code) {
        super(code);
    }

    public void bootloaderCheck() {
        if (this.code == 0)
            System.out.println("Bootloader is present");
        else
            System.out.println("Bootloader check error: code " + this.code);
    }
}
