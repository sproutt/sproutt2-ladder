import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int NON_CONNECTION = 0;
    private static final int CONNECTION = 1;
    private static final int START_INDEX = 0;

    private List<Point> line;

    public Line(int participant) {

        line = new ArrayList<>();

        for (int i = 0; i < participant - 1; i++) {
            line.add(new Point(isConnection(i)));
        }
    }

    public List<Point> getLine() {
        return line;
    }

    private boolean isConnection(int index) {
        if (index == START_INDEX) {
            return selectConnection();
        }

        boolean beforeConnection = (line.get(index - 1)).getConnection();

        if (beforeConnection) {
            return false;
        }

        return selectConnection();
    }

    private boolean selectConnection() {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == NON_CONNECTION) {
            return false;
        } else if (randomNumber == CONNECTION) {
            return true;
        }
        return true;
    }
}