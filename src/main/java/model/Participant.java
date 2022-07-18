package model;

public class Participant {
    private static final int MAX_NAME_SIZE = 5;
    private String name;

    public Participant(String name) {
        validateParticipantNameSize(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateParticipantNameSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new RuntimeException("참여자 이름이 5글자 이상입니다.");
        }
    }
}
