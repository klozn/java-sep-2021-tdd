package codelab02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    @DisplayName("Human bite does nothing")
    void bite_whenNonVampire_thenDoNothing() {
        //given
        Human biter = getHuman();
        Human victim = getHuman();
        //when
        biter.bite(victim, LocalTime.MIDNIGHT);
        //then
        assertFalse(victim.isVampire());
    }

    @Nested
    @DisplayName("Vampire bite:")
    class VampireBite {
        private static Human human;
        private static Human vampire;

        @BeforeAll
        static void setUpVampireAndHuman() {
            human = getHuman();
            vampire = getHuman();
            vampire.setVampire(true);
        }

        @Test
        @DisplayName("Turns human into vampire at midnight")
        void bite_whenVampireBitesHumanAtMidnight_thenHumanTurnsIntoVampire() {
            //given
            LocalTime time = LocalTime.MIDNIGHT;
            //when
            vampireBitesHuman(time);
            //then
            assertTrue(human.isVampire());
        }

        @Test
        @DisplayName("Does nothing at 7AM")
        void bite_whenVampireBitesHumanAfter7AM_thenHumanRemainsHuman() {
            //given
            LocalTime time = LocalTime.of(7, 0);
            //when
            vampireBitesHuman(time);
            //then
            assertFalse(human.isVampire());
        }

        @Test
        @DisplayName("Turns human into vampire between midnight and 7AM")
        void bite_whenVampireBitesHumanBetweenMidnightAnd7AM_thenTurnIntoVampire() {
            //given
            LocalTime time = LocalTime.of(6, 59);
            //when
            vampireBitesHuman(time);
            //then
            assertTrue(human.isVampire());
        }

        private void vampireBitesHuman(LocalTime time) {
            vampire.bite(human, time);
        }
    }

    private static Human getHuman() {
        return new Human();
    }
}