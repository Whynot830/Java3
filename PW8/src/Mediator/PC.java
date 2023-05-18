package Mediator;

public class PC {
    private boolean isOn = false;
    public boolean isOn() {
        return this.isOn;
    }
    public void turnOn() {
        isOn = true;
        System.out.println("Mediator.PC was turned on");
    }
    public void turnOff() {
        isOn = false;
        System.out.println("Mediator.PC was turned off");
    }
}
