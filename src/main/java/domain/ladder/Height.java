package domain.ladder;

public class Height {
    private static final String INPUT_POSITIVE_MESSAGE = "[ERROR] 높이는 0 초과를 입력합니다.";
    private int height;

    public Height(int height) {
        validatePositive(height);
        this.height = height;
    }

    public void validatePositive(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(INPUT_POSITIVE_MESSAGE);
        }
    }

    public int getHeight() {
        return height;
    }
}
