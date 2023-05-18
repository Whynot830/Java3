package AbstractFactory;

public abstract class AbstractFactory<T> {
    public abstract T create(String type);
}
