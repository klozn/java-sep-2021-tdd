package codelab01;

import codelab01.busses.Bus;
import codelab01.busses.ElectricBus;
import codelab01.busses.HybridBus;
import codelab01.busses.LiquidFuelBus;

public class Main {
    public static void main(String[] args) {
        ElectricFuel electricBus = new ElectricBus(75, 3.99);
        LiquidFuel fuelBus = new LiquidFuelBus(75, 2.99, 45);
        Bus hybridBus = new HybridBus(75, 3.3, 15);
        ElectricFuel hybridBus2 = new HybridBus(75, 3.5, 10);
        LiquidFuel hybridBus3 = new HybridBus(75, 3.5, 10);

        Bus[] busses = new Bus[] {(Bus) electricBus, (Bus) fuelBus, hybridBus, (Bus) hybridBus2, (Bus) hybridBus3};

        ServiceStation station = new ServiceStation();

        station.fillFuelTank(fuelBus);
        station.fillFuelTank(hybridBus3);

        station.rechargeBattery(electricBus);
        station.rechargeBattery(hybridBus2);

        for (Bus bus : busses) {
            station.refillOrRecharge(bus);
        }

        hybridBus.drive(500);

    }
}
