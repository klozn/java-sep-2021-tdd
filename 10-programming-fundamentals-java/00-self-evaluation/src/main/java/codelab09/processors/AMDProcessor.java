package codelab09.processors;

public class AMDProcessor extends Processor {

    public AMDProcessor(String modelNr, int ram, String socketType, String systemType, int nrOfCores,
                        int maxClockSpeed) {
        super("AMD", modelNr, ram, socketType, systemType, nrOfCores, maxClockSpeed);
    }

    @Override
    protected void processInstruction(ProcessorInstruction instruction) {
        System.out.println("AMD processing: " + instruction);
    }
}
