package codelab01;

import codelab01.busses.Bus;

public class ServiceStation {
    public void rechargeBattery(ElectricFuel vehicle) {
        vehicle.recharge();
    }

    public void fillFuelTank(LiquidFuel vehicle) {
        vehicle.fillWithFuel();
    }

    public void refillOrRecharge(Bus bus) {
        if (bus instanceof ElectricFuel) {
            ((ElectricFuel) bus).recharge();
        }
        if (bus instanceof LiquidFuel) {
            ((LiquidFuel) bus).fillWithFuel();
        }
    }
}
