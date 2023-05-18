import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();
        list.add(new Human(20, "Alex", "Brown", LocalDate.of(2003, 1, 15), 71));
        list.add(new Human(18, "Sam", "Smith", LocalDate.of(2005, 5, 11), 60));
        list.add(new Human(25, "Bob", "Johnson", LocalDate.of(1998, 2, 1), 80));
        list.add(new Human(23, "Jay", "Fox", LocalDate.of(2000, 10, 2), 101));
        list.add(new Human(23, "Josh", "Fisher", LocalDate.of(2000, 12, 9), 89));
        list.add(new Human(22, "William", "Ford", LocalDate.of(2001, 12, 18), 59));
        list.add(new Human(21, "Stacy", "Marshall", LocalDate.of(2002, 10, 20), 51));
        list.add(new Human(24, "Vinnie", "Green", LocalDate.of(1999, 6, 12), 93));
        list.add(new Human(34, "Ann", "Richards", LocalDate.of(1989, 3, 23), 61));
        list.add(new Human(33, "Riley", "Nixon", LocalDate.of(1990, 9, 8), 57));
        list.add(new Human(24, "Lana", "Zinc", LocalDate.of(1999, 9, 10), 70));
        list.add(new Human(16, "Andrew", "Osborne", LocalDate.of(2007, 1, 11), 49));
        list.add(new Human(26, "Toby", "Harrison", LocalDate.of(1997, 3, 9), 115));
        System.out.println(list.stream()
                .sorted(Comparator.comparingInt(human -> human.firstName.charAt(1)))
                .toList());
        System.out.println(list.stream()
                .filter(human -> human.weight % 10 == 0)
                .toList());
        System.out.println(list.stream().
                mapToInt(human -> human.weight)
                .reduce((a,b) -> a * b).
                getAsInt());
    }
}