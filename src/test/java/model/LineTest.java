package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    public void should_line_size_is_equal_to_player_size_minus_1() {
        int playerSize = 5;

        assertThat(new Line(playerSize).getLine().size()).isEqualTo(playerSize-1);
    }
}