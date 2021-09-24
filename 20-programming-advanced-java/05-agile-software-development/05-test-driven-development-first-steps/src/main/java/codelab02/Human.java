package codelab02;

import java.time.LocalTime;

public class Human {
    private boolean vampire;

    public boolean isVampire() {
        return vampire;
    }

    public void setVampire(boolean vampire) {
        this.vampire = vampire;
    }

    public void bite(Human human, LocalTime time) {
        if (this.isVampire()) {
            if (time == LocalTime.MIDNIGHT ||
                    (time.isAfter(LocalTime.MIDNIGHT) && time.isBefore(LocalTime.of(7,0)))) {
                human.setVampire(true);
            }
        }
    }
}
