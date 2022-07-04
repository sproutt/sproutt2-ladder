public class Participant {
    private static final int MAX_NAME_SIZE = 5;
    private String name;

    public Participant(String name) {
        validateParticipantNameSize(name);
        this.name = name;
    }

    private void validateParticipantNameSize(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("참여자 이름이 5글자 이상입니다.");
        }
    }
}
