package Facade;

public class MBR extends Component {
    public MBR() {
        super();
    }

    public MBR(int code) {
        super(code);
    }

    public void moveData() {
        if (this.code == 0)
            System.out.println("Data moved successfully");
        else
            System.out.println("Data transfer failed: code " + this.code);

    }
}
