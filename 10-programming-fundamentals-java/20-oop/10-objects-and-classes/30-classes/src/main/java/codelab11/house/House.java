package codelab11.house;

import codelab11.Food;
import codelab11.staff.*;

public class House {

    private Bathroom bathroom;
    private Kitchen kitchen;
    private Diningroom diningroom;
    private Garden garden;
    private Staff staff;

    private House(Bathroom bathroom, Kitchen kitchen, Diningroom diningroom, Garden garden, Staff staff) {
        this.bathroom = bathroom;
        this.kitchen = kitchen;
        this.diningroom = diningroom;
        this.garden = garden;
        this.staff = staff;
    }

    public void tendToGarden() {
        staff.tendTo(garden);
    }

    public Food prepareFood() {
        return staff.prepareFood(kitchen);
    }

    public void serveFood(Food food) {
        staff.serveFood(food, diningroom);
    }

    public void fixBathroom() {
        staff.fixBathroom(bathroom);
    }

    public static class Builder {
        private Bathroom bathroom;
        private Kitchen kitchen;
        private Diningroom diningroom;
        private Garden garden;
        private Staff staff;

        public Builder withBathroom(Bathroom bathroom) {
            this.bathroom = bathroom;
            return this;
        }

        public Builder withKitchen(Kitchen kitchen) {
            this.kitchen = kitchen;
            return this;
        }

        public Builder withDiningroom(Diningroom diningroom) {
            this.diningroom = diningroom;
            return this;
        }

        public Builder withGarden(Garden garden) {
            this.garden = garden;
            return this;
        }

        public Builder withStaff(Staff staff) {
            this.staff = staff;
            return this;
        }

        public House build() {
            return new House(bathroom, kitchen, diningroom, garden, staff);
        }
    }
}
