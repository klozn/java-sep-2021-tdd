package codelab09;

import codelab09.peripherals.Keyboard;
import codelab09.peripherals.KeyboardLayout;
import codelab09.peripherals.Mouse;
import codelab09.processors.IntelProcessor;
import codelab09.processors.Processor;
import codelab09.processors.ProcessorInstruction;
import codelab09.processors.ProcessorMode;
import codelab09.screens.LEDScreen;
import codelab09.screens.Screen;
import codelab09.storagedevices.SSD;
import codelab09.storagedevices.StorageDevice;

public class Main {
    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard(KeyboardLayout.AZERTY);
        Mouse mouse = new Mouse();
        Processor intelProcessor = new IntelProcessor("i5-10310U",16, "LGA-1151", "64-bit",
                4, 2);
        Screen ledScreen = new LEDScreen(17,"1920x1080p");
        StorageDevice ssdStorage = new SSD("Samsung", "970 Evo Plus NVMe", 3500,
                500_000_000, false);
        Laptop laptop = new Laptop.Builder()
                .withProcessor(intelProcessor)
                .withScreen(ledScreen)
                .withStorageDevice(ssdStorage)
                .withNrOfUSBPorts(4)
                .withPeripheralDevice(keyboard, 0)
                .withPeripheralDevice(mouse, 1)
                .build();

        System.out.println(laptop);

        intelProcessor.setMode(ProcessorMode.OVERCLOCKED);
        intelProcessor.addInstruction(new ProcessorInstruction("say hello"));
        intelProcessor.addInstruction(new ProcessorInstruction("say goodbye"));
        intelProcessor.processInstructions();
        System.out.println(intelProcessor.getActiveEnergyConsumptionInKWH());
        System.out.println(intelProcessor.getIdleEnergyConsumptionInKWH());

        ledScreen.brighten();
        ledScreen.dim();
        ledScreen.dim();
        ledScreen.brighten();
        System.out.println(ledScreen);

        ssdStorage.storeData(new byte[]{1,5,36,7,5,0,14});
        System.out.println(ssdStorage.getData()[2]);
        System.out.println(ssdStorage.getUnusedSpace());
    }
}