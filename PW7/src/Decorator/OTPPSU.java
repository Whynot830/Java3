package Decorator;

public class OTPPSU extends PSUDecorator {

    public OTPPSU(PowerSupplyUnit psu) {
        super(psu);
    }

    @Override
    public void turnOn() {
        System.out.println("Over temperature protection is active");
        super.turnOn();
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1500;
    }
}
