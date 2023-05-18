package Builder;

public class PersonalComputer {
    private String motherboard;
    private String cpu;
    private String gpu;
    private String ram;
    private String ssd;
    private String hdd;
    private String powerSupply;

    public PersonalComputer(String motherboard, String cpu, String gpu, String ram, String ssd, String hdd, String powerSupply) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.ssd = ssd;
        this.hdd = hdd;
        this.powerSupply = powerSupply;
    }

    private PersonalComputer() {

    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public String getRam() {
        return ram;
    }

    public String getSsd() {
        return ssd;
    }

    public String getHdd() {
        return hdd;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public static Builder newBuilder() {
        return new PersonalComputer().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setMotherboard(String motherboard) {
            PersonalComputer.this.motherboard = motherboard;
            return this;
        }

        public Builder setCpu(String cpu) {
            PersonalComputer.this.cpu = cpu;
            return this;
        }

        public Builder setGpu(String gpu) {
            PersonalComputer.this.gpu = gpu;
            return this;
        }

        public Builder setRam(String ram) {
            PersonalComputer.this.ram = ram;
            return this;
        }

        public Builder setSsd(String ssd) {
            PersonalComputer.this.ssd = ssd;
            return this;
        }

        public Builder setHdd(String hdd) {
            PersonalComputer.this.hdd = hdd;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            PersonalComputer.this.powerSupply = powerSupply;
            return this;
        }

        public PersonalComputer build() {
            return PersonalComputer.this;
        }
    }

    @Override
    public String toString() {
        return "Personal Computer" + '\n' + "Motherboard: " + motherboard + '\n' + "CPU: " + cpu + '\n' + "GPU: " + gpu + '\n' + "RAM: " + ram + '\n' + "SSD: " + ssd + '\n' + "HDD: " + hdd + '\n' + "Power Supply: " + powerSupply + '\n';
    }
}
