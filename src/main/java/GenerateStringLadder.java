import java.util.ArrayList;
import java.util.List;

public class GenerateStringLadder {
    private static final String POINT = "|";
    private static final String EMPTY = "     ";
    private static final String CONNECTION = "-----";

    public List<ArrayList<String>> generateStringLadder(List<Participant> participants, List<Line> lines, List<Winning> winnings) {
        List<ArrayList<String>> generatedStringLadder = new ArrayList<>();

        generatedStringLadder.add(toStringParticipantList(participants));

        for (int i = 0; i < lines.size(); i++) {
            List<String> generatedLine = new ArrayList<>();
            Line line = lines.get(i);
            generatedLine.add(POINT);

            for (int j = 0; j < line.getLine().size(); j++) {
                if ((line.getLine().get(j)).getConnection() == false) {
                    generatedLine.add(EMPTY);
                }
                if (line.getLine().get(j).getConnection() == true) {
                    generatedLine.add(CONNECTION);
                }
                generatedLine.add(POINT);
            }
            generatedStringLadder.add((ArrayList<String>) generatedLine);
        }

        generatedStringLadder.add(toStringWinningList(winnings));

        return generatedStringLadder;
    }

    private ArrayList<String> toStringParticipantList(List<Participant> participants) {
        ArrayList<String> stringParticipantList = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            stringParticipantList.add(participants.get(i).getName());
            stringParticipantList.add("  ");
        }
        return stringParticipantList;
    }

    private ArrayList<String> toStringWinningList(List<Winning> winnings) {
        ArrayList<String> stringWinningList = new ArrayList<>();
        for (int i = 0; i < winnings.size(); i++) {
            stringWinningList.add(winnings.get(i).getWinningInput());
            stringWinningList.add("  ");
        }
        return stringWinningList;
    }
}