package Builder;

import FactoryMethod.CentralProcessingUnit;

public class CpuBuildDirector {
    private CpuBuilder builder = new CpuBuilder();
    public CentralProcessingUnit build(String type) {
        builder.buildPart(type);
        return builder.getResult();
    }
}
