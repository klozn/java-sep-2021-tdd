package grasp.creator;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @Test
    void hitBombThanLoose() {
        Board board = new Board(Lists.newArrayList(new Coordinate(1, 1)));

        board.hit(new Coordinate(1,1));

        assertThat(board.isDead()).isTrue();
        assertThat(board.hasWon()).isFalse();
    }

    @Test
    void hitOtherThingThanBombThanNotLoose() {
        Board board = new Board(Lists.newArrayList(new Coordinate(1, 1)));

        board.hit(new Coordinate(1,2));

        assertThat(board.isDead()).isFalse();
        assertThat(board.hasWon()).isFalse();
    }
}
