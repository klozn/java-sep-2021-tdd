package codelab11.staff;

import codelab11.Food;
import codelab11.house.Bathroom;
import codelab11.house.Diningroom;
import codelab11.house.Garden;
import codelab11.house.Kitchen;

public class Staff {

    private Gardener gardener;
    private Butler butler;
    private Cook cook;
    private Plumber plumber;

    private Staff(Gardener gardener, Butler butler, Cook cook, Plumber plumber) {
        this.gardener = gardener;
        this.butler = butler;
        this.cook = cook;
        this.plumber = plumber;
    }

    public void setGardener(Gardener gardener) {
        this.gardener = gardener;
    }

    public void setButler(Butler butler) {
        this.butler = butler;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void setPlumber(Plumber plumber) {
        this.plumber = plumber;
    }

    public void tendTo(Garden garden) {
        gardener.tendTo(garden);
    }

    public Food prepareFood(Kitchen kitchen) {
        return cook.prepareFood(kitchen);
    }

    public void serveFood(Food food, Diningroom diningroom) {
        butler.serveFood(food, diningroom);
    }

    public void fixBathroom(Bathroom bathroom) {
        plumber.fixBathroom(bathroom);
    }

    public static class Builder {
        private Gardener gardener;
        private Butler butler;
        private Cook cook;
        private Plumber plumber;

        public Builder withGardener(Gardener gardener) {
            this.gardener = gardener;
            return this;
        }

        public Builder withButler(Butler butler) {
            this.butler = butler;
            return this;
        }

        public Builder withCook(Cook cook) {
            this.cook = cook;
            return this;
        }

        public Builder withPlumber(Plumber plumber) {
            this.plumber = plumber;
            return this;
        }

        public Staff build() {
            return new Staff(gardener, butler, cook, plumber);
        }
    }
}
