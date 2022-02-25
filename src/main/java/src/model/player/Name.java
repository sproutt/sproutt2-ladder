package src.model.player;

public class Name {

	private static final String OVER_FIVE_LETTERS_NAME_ERROR_MESSAGE = "이름은 5글자를 넘을 수 없습니다.";
	private static final String EMPTY_NAME_ERROR_MESSAGE = "이름은 1글자 이상이어야 합니다.";

	private String name;

	public Name(String name) {
		validateEmptyName(name);
		validateFiveLetter(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validateFiveLetter(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException(OVER_FIVE_LETTERS_NAME_ERROR_MESSAGE);
		}
	}

	private void validateEmptyName(String name){
		if (name.length() == 0){
			throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
		}
	}
}
