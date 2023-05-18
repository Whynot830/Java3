package Mediator;

public class Mediator {
    private PowerSupplyUnit psu = new PowerSupplyUnit();
    private Switcher switcher = new Switcher();
    private PC pc = new PC();
    public void press() {
        if (pc.isOn())
            pc.turnOff();
        else
            if (psu.isOn())
                pc.turnOn();
            else
                System.out.println("PSU is not on\nUnable to turn on Mediator.PC");
    }
    public void start() {
        psu.turnOn();
    }
    public void stop() {
        psu.turnOff();
    }
}
