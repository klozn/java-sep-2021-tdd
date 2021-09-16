package codelab01.busses;

import codelab01.LiquidFuel;

public class LiquidFuelBus extends Bus implements LiquidFuel {
    public final static int MAX_LITERS_OF_FUEL = 150;
    public final static double LITERS_OF_FUEL_LOST_PER_KM = 0.5;

    private double litersOfLiquidInTank;
    private int emission;

    public LiquidFuelBus(int capacity, double cost, int emission) {
        super(capacity, cost);
        this.litersOfLiquidInTank = MAX_LITERS_OF_FUEL;
        this.emission = emission;
    }

    @Override
    public void drive(int kilometers) {
        if (litersOfLiquidInTank > LITERS_OF_FUEL_LOST_PER_KM) {
            for (int i = 0; litersOfLiquidInTank > LITERS_OF_FUEL_LOST_PER_KM && i < kilometers; i++) {
                litersOfLiquidInTank -= LITERS_OF_FUEL_LOST_PER_KM;
                if (litersOfLiquidInTank < LITERS_OF_FUEL_LOST_PER_KM) {
                    System.out.printf("We have driven %d km, fuel tank needs a refill.\n", i);
                }
            }
            System.out.printf("Liters of fuel left: %.2f l\n", litersOfLiquidInTank);
        } else {
            System.out.println("Fuel tank needs a refill before driving.");
        }
    }

    @Override
    public int getEmission() {
        return emission;
    }

    @Override
    public void fillWithFuel() {
        litersOfLiquidInTank = MAX_LITERS_OF_FUEL;
        System.out.println("Filling up my tank!");
    }
}
