package codelab01.busses;

import codelab01.ElectricFuel;

public class ElectricBus extends Bus implements ElectricFuel {
    public final static int MAX_VOLTAGE = 10_000;
    public final static int VOLTAGE_LOST_PER_KM = 100;
    private int voltage;

    public ElectricBus(int capacity, double cost) {
        super(capacity, cost);
        voltage = MAX_VOLTAGE;
    }

    @Override
    public void drive(int kilometers) {
        if (voltage > VOLTAGE_LOST_PER_KM) {
            for (int i = 0; voltage > VOLTAGE_LOST_PER_KM && i < kilometers; i++) {
                voltage -= VOLTAGE_LOST_PER_KM;
                if (voltage < VOLTAGE_LOST_PER_KM) {
                    System.out.printf("We have driven %d km, the battery has run out.\n", i);
                }
            }
            System.out.printf("Voltage left in battery: %dV\n", voltage);
        } else {
            System.out.println("Battery needs a recharge before driving.");
        }
    }

    @Override
    public int getVoltage() {
        return voltage;
    }

    @Override
    public void recharge() {
        voltage = MAX_VOLTAGE;
        System.out.println("Recharging my batteries!");
    }
}
