package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final String POINT = "|";
    private static final String EMPTY = "     ";
    private static final String CONNECTION = "-----";
    private static List<List<String>> stringLadder;
    private List<String> stringLine;
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder() {

    }

    public List<Line> getLines() {
        return lines;
    }

    public Ladder generateLadder(int height, int players) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(players));
        }

        return new Ladder(lines);
    }

    public List<List<String>> generateStringLadder(Ladder ladder, List<StringInfo> players, List<StringInfo> winnings) {
        stringLadder = new ArrayList<>();

        stringLadder.add(toStringList(players));

        for (int i = 0; i < ladder.getLines().size(); i++) {
            Line line = ladder.getLines().get(i);

            stringLadder.add(generateStringLine(line));
        }

        stringLadder.add(toStringList(winnings));

        return stringLadder;
    }

    private List<String> generateStringLine(Line line) {
        stringLine = new ArrayList<>();
        for (int i = 0; i < line.getPoints().size() - 1; i++) {
            if (line.getPoints().get(i).getDirection().isRightFlag()) {
                stringLine.add(POINT);
                stringLine.add(CONNECTION);
            }
            if (!line.getPoints().get(i).getDirection().isRightFlag()) {
                stringLine.add(POINT);
                stringLine.add(EMPTY);
            }
        }
        stringLine.add(POINT);
        return stringLine;
    }

    private List<String> toStringList(List<StringInfo> infoList) {
        stringLine = new ArrayList<>();
        for (StringInfo stringInfo : infoList) {
            stringLine.add(stringInfo.getStringInfo());
            stringLine.add("  ");
        }
        return stringLine;
    }
}