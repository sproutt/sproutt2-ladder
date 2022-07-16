import java.util.List;

public class Ladder {
    private List<Line> ladder;
    public Ladder(List<Line> ladder){
        this.ladder = ladder;
    }

    public Line getLadder(int i) {
        return ladder.get(i);
    }
}