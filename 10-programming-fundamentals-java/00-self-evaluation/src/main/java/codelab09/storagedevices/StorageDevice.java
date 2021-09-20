package codelab09.storagedevices;

import codelab09.EnergyConsumer;

public abstract class StorageDevice implements EnergyConsumer {
    private final String manufacturer;
    private final String modelNr;
    private final int speed;
    private final int capacity;
    private final boolean external;
    private byte[] data;
    private int usedSpace;

    private int activeEnergyConsumption;
    private int idleEnergyConsumption;

    public StorageDevice(String manufacturer, String modelNr, int speed, int capacity, boolean external) {
        this.manufacturer = manufacturer;
        this.modelNr = modelNr;
        this.speed = speed;
        this.capacity = capacity;
        this.external = external;
        data = new byte[capacity];
        usedSpace = 0;
    }

    public byte[] getData() {
        return data;
    }

    public int getUnusedSpace() {
        return capacity - usedSpace;
    }

    public void storeData(byte[] data) {
        if (data.length > getUnusedSpace()) {
            throw new NotEnoughFreeSpaceException("Not enough space available.");
        } else {
            for (int i = 0; i < data.length; i++) {
                getData()[usedSpace + i] = data[i];
            }
            usedSpace += data.length;
        }
    }

    @Override
    public int getActiveEnergyConsumptionInKWH() {
        return activeEnergyConsumption;
    }

    @Override
    public int getIdleEnergyConsumptionInKWH() {
        return idleEnergyConsumption;
    }
}
