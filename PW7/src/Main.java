import Decorator.*;
import Facade.*;
public class Main {
    public static void main(String[] args) {
        String bl = '\n' + "=".repeat(50);
        System.out.println(bl);
        System.out.println("DECORATOR PATTERN\n");
        PowerSupplyUnit aeroCool600w = new BasicPSU();
        aeroCool600w.turnOn();
        System.out.println(aeroCool600w.getPrice());

        System.out.println();
        PowerSupplyUnit deepCoolPq650m = new OVPPSU(new OLPPSU(new OTPPSU(new BasicPSU())));
        deepCoolPq650m.turnOn();
        System.out.println(deepCoolPq650m.getPrice());

        System.out.println(bl);
        System.out.println("FACADE PATTERN\n");
        PC pc = new PC(3, 2, 2, 1);
        pc.turnOn();
    }
}
