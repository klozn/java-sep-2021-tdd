package com.switchfully.programming.advanced.integration.testing.laundry;

public enum LaundryType {
    WOOL("wool"), WHITE("white"), COLOR("color"), SUIT("suit");

    private final String label;

    LaundryType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
