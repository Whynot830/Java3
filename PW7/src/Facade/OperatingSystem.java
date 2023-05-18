package Facade;

public class OperatingSystem extends Component {
    public OperatingSystem() {
        super();
    }

    public OperatingSystem(int code) {
        super(code);
    }

    public void boot() {
        if (this.code == 0)
            System.out.println("Operating system is loaded successfully");
        else
            System.out.println("Operating system loading failed: code " + this.code);
    }
}
