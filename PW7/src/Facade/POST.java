package Facade;

public class POST extends Component {
    public POST() {
        super();
    }
    public POST(int code) {
        super(code);
    }

    public void check() {
        if (this.code == 0)
            System.out.println("Power-ON Self Test passed");
        else
            System.out.println("Power-ON Self Test failed: code " + this.code);
    }
}
