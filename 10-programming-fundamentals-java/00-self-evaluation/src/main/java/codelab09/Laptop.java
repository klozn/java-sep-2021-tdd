package codelab09;

import codelab09.peripherals.PeripheralDevice;
import codelab09.processors.Processor;
import codelab09.screens.Screen;
import codelab09.storagedevices.StorageDevice;

import java.util.Arrays;

public class Laptop {
    private final Screen screen;
    private final StorageDevice storageDevice;
    private final int ram;
    private final Processor processor;
    private final int nrOfUSBPorts;
    private final PeripheralDevice[] peripherals;

    private Laptop(Screen screen, StorageDevice storageDevice, Processor processor, int nrOfUSBPorts, PeripheralDevice[] peripherals) {
        this.screen = screen;
        this.storageDevice = storageDevice;
        this.processor = processor;
        ram = processor.getRam();
        this.nrOfUSBPorts = nrOfUSBPorts;
        this.peripherals = peripherals;
        for (PeripheralDevice peripheral : peripherals) {
            if (peripheral != null) {
                peripheral.use();
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("screen=").append(screen).append('\n');
        sb.append(", storageDevice=").append(storageDevice).append('\n');
        sb.append(", ram=").append(ram).append('\n');
        sb.append(", processor=").append(processor).append('\n');
        sb.append(", nrOfUSBPorts=").append(nrOfUSBPorts).append('\n');
        sb.append(", peripherals=").append(Arrays.toString(peripherals));
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private Screen screen;
        private StorageDevice storageDevice;
        private Processor processor;
        private int nrOfUSBPorts;
        private PeripheralDevice[] peripherals;

        public Builder() {
            nrOfUSBPorts = 1;
            peripherals = new PeripheralDevice[nrOfUSBPorts];
        }

        public Builder withScreen(Screen screen) {
            this.screen = screen;
            return this;
        }

        public Builder withStorageDevice(StorageDevice storageDevice) {
            this.storageDevice = storageDevice;
            return this;
        }

        public Builder withProcessor(Processor processor) {
            this.processor = processor;
            return this;
        }

        public Builder withNrOfUSBPorts(int nrOfUSBPorts) {
            if (nrOfUSBPorts > 5 || nrOfUSBPorts < 0) {
                throw new IllegalArgumentException("A laptop can have 0 to 5 USB Ports.");
            }
            this.nrOfUSBPorts = nrOfUSBPorts;
            peripherals = new PeripheralDevice[nrOfUSBPorts];
            return this;
        }

        public Builder withPeripheralDevice(PeripheralDevice device, int USBPortIndex) {
            if (USBPortIndex > nrOfUSBPorts - 1) {
                throw new IllegalArgumentException("There is no USB Port with index: " + USBPortIndex);
            }
            peripherals[USBPortIndex] = device;
            return this;
        }

        public Laptop build() {
            return new Laptop(screen, storageDevice, processor, nrOfUSBPorts, peripherals);
        }
    }
}
