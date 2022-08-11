package model;

import exception.PlayerNameIsOverMaxNameSizeException;

public class Player {
    private static final int MAX_NAME_SIZE = 5;
    private static final String OVER_MAX_NAME_SIZE_EXCEPTION = "참여자 이름이 5글자 이상입니다.";
    StringInfo playerInfo;

    public Player(String name) {
        validatePlayerNameSize(name);
        this.playerInfo = new StringInfo(name);
    }

    private void validatePlayerNameSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new PlayerNameIsOverMaxNameSizeException(OVER_MAX_NAME_SIZE_EXCEPTION);
        }
    }
}