package model;

<<<<<<< HEAD:src/main/java/model/Participant.java
public class Participant {
    private static final int MAX_NAME_SIZE = 5;
    private String name;

    public Participant(String name) {
        validateParticipantNameSize(name);
        this.name = name;
=======
import exception.PlayerNameIsOverMaxNameSizeException;

public class Player extends Info {
    private static final int MAX_NAME_SIZE = 5;
    private static final String OVER_MAX_NAME_SIZE_EXCEPTION = "참여자 이름이 5글자 이상입니다.";

    public Player(String name) {
        validatePlayerNameSize(name);
        this.info = name;
>>>>>>> eb4e902 (refactor : Winning과 Player 중복을 줄이기 위한 Info 생성):src/main/java/model/Player.java
    }

    private void validatePlayerNameSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new RuntimeException("참여자 이름이 5글자 이상입니다.");
        }
    }
}