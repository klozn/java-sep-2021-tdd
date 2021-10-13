package com.switchfully.springdi.codelab01.v5.entities;

import com.switchfully.springdi.codelab01.v5.enums.DriverLicenseType;
import org.springframework.beans.factory.annotation.Autowired;

public class DriversLicense {
    private DriverLicenseType licenseType;

    @Autowired
    public DriversLicense(DriverLicenseType licenseType) {
        this.licenseType = licenseType;
    }

    public boolean isPermitForSmallVehicle() {
        if (isPermitForLargeVehicle()) {
            return true;
        } else {
            return DriverLicenseType.B == licenseType;
        }
    }

    public boolean isPermitForLargeVehicle() {
        return switch (licenseType) {
            case C, D -> true;
            default -> false;
        };
    }
}
