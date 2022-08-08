package controller;

import model.Height;
import model.StringInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("참가자 사이즈와 당첨 사이즈가 다르면 예외를 발생한다.")
    public void should_throw_exception_when_player_size_and_winning_size_is_not_same() {
        // given
        List<StringInfo> testPlayer = new ArrayList<>();
        List<StringInfo> testWinning = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            testPlayer.add(new StringInfo("a"));
        }

        for (int i = 0; i < 4; i++) {
            testWinning.add(new StringInfo("1"));
        }

        // when
        Throwable exception = assertThrows(RuntimeException.class, () -> new LadderGame(testPlayer, testWinning, new Height(3)));

        // then
        assertEquals("당첨 결과 개수와 참가자 수가 같지 않습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("참가자 사이즈와 당첨 사이즈가 같으면 성공이다.")
    public void should_success_when_player_size_and_winning_size_is_same() {
        // given
        List<StringInfo> testPlayer = new ArrayList<>();
        List<StringInfo> testWinning = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            testPlayer.add(new StringInfo("a"));
        }

        for (int i = 0; i < 3; i++) {
            testWinning.add(new StringInfo("1"));
        }

        // when & then
        assertThatCode(() -> new LadderGame(testPlayer, testWinning, new Height(3))).doesNotThrowAnyException();
    }
}