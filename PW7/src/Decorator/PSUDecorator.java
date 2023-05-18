package Decorator;

public class PSUDecorator implements PowerSupplyUnit {
    protected PowerSupplyUnit psu;
    public PSUDecorator(PowerSupplyUnit psu) {
        this.psu = psu;
    }

    @Override
    public void turnOn() {
        this.psu.turnOn();
    }

    @Override
    public int getPrice() {
        return psu.getPrice();
    }
}
