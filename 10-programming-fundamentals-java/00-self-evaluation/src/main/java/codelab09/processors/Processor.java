package codelab09.processors;

import codelab09.EnergyConsumer;

import java.util.Arrays;
import java.util.Stack;

public abstract class Processor implements EnergyConsumer {
    private final String make;
    private final String modelNr;
    private final String socketType;
    private final String systemType;
    private final int nrOfCores;
    private final int maxClockSpeed;
    private final Thread[] threads;
    private final int ram;
    private ProcessorMode mode;
    private Stack<ProcessorInstruction> instructions;

    private int activeEnergyConsumption;
    private int idleEnergyConsumption;

    public Processor(String make, String modelNr, int ram, String socketType, String systemType, int nrOfCores, int maxClockSpeed) {
        this.make = make;
        this.modelNr = modelNr;
        this.ram = ram;
        this.socketType = socketType;
        this.systemType = systemType;
        this.nrOfCores = nrOfCores;
        this.maxClockSpeed = maxClockSpeed;
        threads = new Thread[nrOfCores * 2];
        mode = ProcessorMode.NORMAL;
        instructions = new Stack<>();
    }

    public void setMode(ProcessorMode mode) {
        this.mode = mode;
    }

    public int getRam() {
        return ram;
    }

    public void addInstruction(ProcessorInstruction instruction) {
        instructions.push(instruction);
    }

    public void processInstructions() {
        while (instructions.size() > 0) {
            processInstruction(instructions.pop());
        }
    }

    protected abstract void processInstruction(ProcessorInstruction instruction);

    @Override
    public int getActiveEnergyConsumptionInKWH() {
        return activeEnergyConsumption;
    }

    @Override
    public int getIdleEnergyConsumptionInKWH() {
        return idleEnergyConsumption;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Processor{");
        sb.append("make='").append(make).append('\'');
        sb.append(", modelNr='").append(modelNr).append('\'');
        sb.append(", socketType='").append(socketType).append('\'');
        sb.append(", systemType='").append(systemType).append('\'');
        sb.append(", nrOfCores=").append(nrOfCores);
        sb.append(", maxClockSpeed=").append(maxClockSpeed);
        sb.append(", threads=").append(Arrays.toString(threads));
        sb.append(", ram=").append(ram);
        sb.append(", mode=").append(mode);
        sb.append('}');
        return sb.toString();
    }
}
