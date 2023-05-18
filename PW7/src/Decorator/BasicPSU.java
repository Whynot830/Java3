package Decorator;

public class BasicPSU implements PowerSupplyUnit {
    @Override
    public void turnOn() {
        System.out.println("Power supply unit is on");
    }

    @Override
    public int getPrice() {
        return 2000;
    }
}
