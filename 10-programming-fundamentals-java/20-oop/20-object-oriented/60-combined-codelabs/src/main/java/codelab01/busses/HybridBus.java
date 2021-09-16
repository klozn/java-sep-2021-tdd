package codelab01.busses;

import codelab01.ElectricFuel;
import codelab01.LiquidFuel;

public class HybridBus extends Bus implements ElectricFuel, LiquidFuel {
    public final static int MAX_VOLTAGE = 1_000;
    public final static int VOLTAGE_LOST_PER_KM = 100;
    public final static int MAX_LITERS_OF_FUEL = 150;
    public final static double LITERS_OF_FUEL_LOST_PER_KM = 0.2;

    private double litersOfLiquidInTank;
    private int voltage;
    private int emission;

    public HybridBus(int capacity, double cost, int emission) {
        super(capacity, cost);
        litersOfLiquidInTank = MAX_LITERS_OF_FUEL;
        voltage = MAX_VOLTAGE;
        this.emission = emission;
    }

    @Override
    public void drive(int kilometers) {
        if (litersOfLiquidInTank > LITERS_OF_FUEL_LOST_PER_KM || voltage > VOLTAGE_LOST_PER_KM) {
            if (litersOfLiquidInTank < LITERS_OF_FUEL_LOST_PER_KM) {
                driveOnVoltageOnly(kilometers);
            } else if (voltage < VOLTAGE_LOST_PER_KM) {
                driveOnLiquidFuelOnly(kilometers);
            } else {
                for (int i = 0; i < kilometers && (litersOfLiquidInTank > LITERS_OF_FUEL_LOST_PER_KM
                        || voltage > VOLTAGE_LOST_PER_KM); i++) {
                    litersOfLiquidInTank -= LITERS_OF_FUEL_LOST_PER_KM;
                    voltage -= VOLTAGE_LOST_PER_KM;
                    if (litersOfLiquidInTank < LITERS_OF_FUEL_LOST_PER_KM) {
                        System.out.printf("We have driven %d km, fuel tank needs a refill.\n", i);
                        driveOnVoltageOnly(kilometers - i);
                    }
                    if (voltage < VOLTAGE_LOST_PER_KM) {
                        System.out.printf("We have driven %d km, battery needs a recharge.\n", i);
                        driveOnLiquidFuelOnly(kilometers - i);
                    }
                }
                System.out.printf("Liters of fuel left: %.2f l\n", litersOfLiquidInTank);
                System.out.printf("Voltage left in battery: %dV\n", voltage);
            }
        } else {
            System.out.println("Battery needs a recharge before driving");
            System.out.println("Fuel tank needs a refill before driving");
        }
    }

    private void driveOnLiquidFuelOnly(int kilometers) {
        for (int i = 0; litersOfLiquidInTank > LITERS_OF_FUEL_LOST_PER_KM && i < kilometers; i++) {
            litersOfLiquidInTank -= LITERS_OF_FUEL_LOST_PER_KM;
            if (litersOfLiquidInTank < LITERS_OF_FUEL_LOST_PER_KM) {
                System.out.printf("We have driven %d km, fuel tank needs a refill.\n", i);
            }
        }
        System.out.printf("Liters of fuel left: %.2f l\n", litersOfLiquidInTank);
    }

    private void driveOnVoltageOnly(int kilometers) {
        for (int i = 0; voltage > VOLTAGE_LOST_PER_KM && i < kilometers; i++) {
            voltage -= VOLTAGE_LOST_PER_KM;
            if (voltage < VOLTAGE_LOST_PER_KM) {
                System.out.printf("We have driven %d km, the battery has run out.\n", i);
            }
        }
        System.out.printf("Voltage left in battery: %dV\n", voltage);
    }

    @Override
    public int getVoltage() {
        return voltage;
    }

    @Override
    public void recharge() {
        voltage = MAX_VOLTAGE;
        System.out.println("Recharging my small batteries");
    }

    @Override
    public int getEmission() {
        return emission;
    }

    @Override
    public void fillWithFuel() {
        litersOfLiquidInTank = MAX_LITERS_OF_FUEL;
        System.out.println("Filling up my small tank!");
    }
}
