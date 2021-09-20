package codelab09.processors;

public class IntelProcessor extends Processor {

    public IntelProcessor(String modelNr, int ram, String socketType, String systemType, int nrOfCores,
                          int maxClockSpeed) {
        super("INTEL", modelNr, ram, socketType, systemType, nrOfCores, maxClockSpeed);
    }

    @Override
    protected void processInstruction(ProcessorInstruction instruction) {
        System.out.println("Intel processing: " + instruction.getInstructionAsText());
    }
}
