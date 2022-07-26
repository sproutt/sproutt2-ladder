package model;

import exception.HeightIsUnderMiniHeightException;

public class Height {
    private static final int MINI_HEIGHT = 1;
    private static final String UNDER_MINI_HEIGHT_EXCEPTION = "사다리 높이가 1 이하입니다.";
    private int height;

    public Height(int height) {
        validateHeightOverMiniHeight(height);
        this.height = height;
    }

    private void validateHeightOverMiniHeight(int height) {
        if (height < MINI_HEIGHT) {
            throw new HeightIsUnderMiniHeightException(UNDER_MINI_HEIGHT_EXCEPTION);
        }
    }

    public int getHeight() {
        return height;
    }
}