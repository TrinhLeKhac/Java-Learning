package designpattern;

// Builder Pattern creates chain of constructor

// Using static inner Builder class

import java.util.*;

class Computer {

    private String computerCase;
    private String CPU;
    private String motherBoard;
    private String GPU;
    private String HDD;
    private String operatingSystem;
    private int powerSupply;
    private int amountOfRAM;

    public static class Builder {
        private String computerCase;
        private String CPU;
        private String motherBoard;
        private String GPU;
        private String HDD;
        private String operatingSystem;
        private int powerSupply;
        private int amountOfRAM;

        public Builder() {}
        public Builder withComputerCase(String computerCase) {
            this.computerCase = computerCase;
            return this;
        }
        public Builder withCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder withMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }
        public Builder withGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }
        public Builder withHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }
        public Builder withOperatorSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }
        public Builder withPowerSupply(int powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }
        public Builder withAmountOfRAM(int amountOfRAM) {
            this.amountOfRAM = amountOfRAM;
            return this;
        }
        public Computer build() {
            Computer computer = new Computer();
            computer.computerCase = this.computerCase;
            computer.CPU = this.CPU;
            computer.motherBoard = this.motherBoard;
            computer.GPU = this.GPU;
            computer.HDD = this.HDD;
            computer.operatingSystem = this.operatingSystem;
            computer.powerSupply = this.powerSupply;
            computer.amountOfRAM = this.amountOfRAM;
            return computer;
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerCase='" + computerCase + '\'' +
                ", CPU='" + CPU + '\'' +
                ", motherBoard='" + motherBoard + '\'' +
                ", GPU='" + GPU + '\'' +
                ", HDD='" + HDD + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", powerSupply=" + powerSupply +
                ", amountOfRAM=" + amountOfRAM +
                '}';
    }
}

public class BuilderExample {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .withComputerCase("Tower")
                .withCPU("Intel i5")
                .withMotherBoard("MSI B360M-MORTAR")
                .withGPU("nVidia Geforce GTX 750ti")
//                .withHDD("Toshiba 1TB")
//                .withOperatorSystem("Windows 10")
                .withPowerSupply(220)
                .withAmountOfRAM(8)
                .build();
        System.out.println("Computer with information: " + computer.toString());
    }
}
