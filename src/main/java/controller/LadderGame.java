package controller;

import model.Ladder;
import model.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public Ladder generateLadder(int height, int participant) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(participant));
        }
        return new Ladder(lines);
    }
}