package domain.gameresult;

public class GameResultName {
    private static final String EMPTY_GAME_RESULT_NAME_ERROR = "[ERROR] 실행 결과 이름은 공백일 수 없습니다.";

    private String name;

    public GameResultName(String name) {
        validateEmptyName(name);
        this.name = name;
    }

    private void validateEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_GAME_RESULT_NAME_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
