package Decorator;

public class OVPPSU extends PSUDecorator {
    public OVPPSU(PowerSupplyUnit psu) {
        super(psu);
    }

    @Override
    public void turnOn() {
        System.out.println("Over voltage protection is active");
        super.turnOn();
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 900;
    }
}
