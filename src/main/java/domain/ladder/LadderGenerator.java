package domain.ladder;

import domain.Line.Line;
import domain.Line.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    public static Ladder generate(int ladderHeight, int playerCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(LineGenerator.generate(playerCount));
        }
        return new Ladder(lines);
    }
}
