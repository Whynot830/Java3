package Builder;

import FactoryMethod.CentralProcessingUnit;
import FactoryMethod.Snapdragon8Gen2;
import FactoryMethod.TensorG2;

public class CpuBuilder implements iBuilder<CentralProcessingUnit> {
    CentralProcessingUnit cpu;
    @Override
    public iBuilder<CentralProcessingUnit> buildPart(String type) {
        cpu = switch (type.toLowerCase()) {
            case "tensor" -> new TensorG2();
            case "snapdragon" -> new Snapdragon8Gen2();
            default -> null;
        };
        return this;
    }

    public CentralProcessingUnit getResult() {
        return cpu;
    }
}
