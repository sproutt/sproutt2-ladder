package domain.player;

import exception.NameFormatException;

public class Name {
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";
    private static final String EMPTY_NAME_ERROR = "[ERROR] 이름은 공백일 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateEmptyName(String name) throws NameFormatException {
        if (name.isEmpty()) {
            throw new NameFormatException(EMPTY_NAME_ERROR);
        }
    }

    private void validateNameLength(String name) throws NameFormatException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new NameFormatException(NAME_LENGTH_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
