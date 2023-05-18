package Builder;

import FactoryMethod.CentralProcessingUnit;

public interface iBuilder<T> {
    public iBuilder buildPart(String type);

    T getResult();
}
