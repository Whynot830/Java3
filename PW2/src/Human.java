import java.time.LocalDate;

public class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName + ' ' + birthDate + " (" + age + "y.o.) " + weight + "kg";
    }
}
