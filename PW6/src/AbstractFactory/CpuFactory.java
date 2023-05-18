package AbstractFactory;

import FactoryMethod.CentralProcessingUnit;
import FactoryMethod.Snapdragon8Gen2;
import FactoryMethod.TensorG2;

public class CpuFactory extends AbstractFactory<CentralProcessingUnit> {
    @Override
    public CentralProcessingUnit create(String type) {
        return switch (type.toLowerCase()) {
            case "tensor" -> new TensorG2();
            case "snapdragon" -> new Snapdragon8Gen2();
            default -> null;
        };
    }
}
