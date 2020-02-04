package org.wecancodeit;

public class RoboPet extends VirtualPet{

	private static final int DEFAULT_RUST_LEVEL = 1;
	private int petRustLevel = DEFAULT_RUST_LEVEL;

	public RoboPet(String petName) {

		super(petName);

	}

	public RoboPet(String petName, String petDescription) {

		super(petName);

		this.petDescription = petDescription;

	}

	public int getPetRustLevel() {

		return petRustLevel ;

	}

	public void oilPet() {

		petRustLevel -=2;
		petHappiness ++;
		petHealth ++;

	}

	public void tick() {

		petHappiness --;
		petRustLevel ++;
		petHealth --;

		if (petRustLevel >= 10) {

			petHealth = 0;

		}

		if (petHappiness <= 0) {

			petHealth = 0;

		}
	}
}
