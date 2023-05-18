import Mediator.Mediator;
import Snapshot.CareTaker;
import Snapshot.PC;

public class Main {
    public static void main(String[] args) {
        String bl = '\n' + "=".repeat(50);
        System.out.println(bl);
        System.out.println("SHAPSHOT PATTERN\n");
        Mediator mediator = new Mediator();
        mediator.press();
        mediator.start();
        mediator.press();
        mediator.press();
        mediator.stop();
        System.out.println(bl);
        System.out.println("MEMENTO PATTERN\n");
        PC pc = new PC("RTX 2060", "I5-12400F", "MSI B660");
        System.out.println("Initial state: " + pc);
        CareTaker careTaker = new CareTaker();
        careTaker.add(pc.saveState());
        pc.setCpu("I9-13900KS");
        pc.setGpu("RTX 4090");
        pc.setMotherboard("MSI Z790");
        System.out.println("New state: " + pc);
        pc.restoreState(careTaker.get(0));
        System.out.println("Restored state: " + pc);
    }
}