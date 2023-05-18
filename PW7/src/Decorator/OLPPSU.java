package Decorator;

public class OLPPSU extends PSUDecorator {

    public OLPPSU(PowerSupplyUnit psu) {
        super(psu);
    }

    @Override
    public void turnOn() {
        System.out.println("Overload protection is active");
        super.turnOn();
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1000;
    }
}
