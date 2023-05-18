package Mediator;

public class PowerSupplyUnit {
    private boolean isOn = false;
    public boolean isOn() {
        return isOn;
    }
    public void turnOn() {
        isOn = true;
        System.out.println("PSU was turned on");
    }
    public void turnOff() {
        isOn = false;
        System.out.println("PSU was turned off");
    }

}
