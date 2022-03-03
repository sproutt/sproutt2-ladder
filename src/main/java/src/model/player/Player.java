package src.model.player;

public class Player {
	private Name name;

	public Player(String name) {
		this.name = new Name(name);
	}

	public String getName() {
		return name.getName();
	}

}
