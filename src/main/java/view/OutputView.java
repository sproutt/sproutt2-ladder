package view;

import java.util.List;

public class OutputView {
    private static final String VERTICAL_BAR = "|";
    private static final String SPACE = "     ";
    private static final String HYPHEN ="-----";

    public OutputView() {

    }

    public void printOneLine(List<Boolean> bridges) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VERTICAL_BAR);
        bridges.forEach(bridge -> {
            stringBuilder.append(makeBridge(bridge));
            stringBuilder.append(VERTICAL_BAR);

        });
        System.out.println(stringBuilder.toString());
    }

    public String makeBridge(boolean isConnected) {
        if (isConnected) {
            return HYPHEN;
        }
        return SPACE;
    }
}
