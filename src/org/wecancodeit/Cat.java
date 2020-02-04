package org.wecancodeit;

public class Cat extends OrganicPet {
	// Constructor
	public Cat(String petName) {

		super(petName);

	}

	public Cat(String petName, String petDescription) {

		super(petName);

		this.petDescription = petDescription;

	}

	public void tick() {
		
		hungerLevel ++;
		thirstLevel ++;
		petHappiness --;

		if (hungerLevel >= 10) {
			petHealth = 0;

		}

		if (petHappiness < 0) {

			petHealth = 0;

		}

		if (wasteLevel >= 6) {

			petBox.makePetBoxDirty(wasteLevel);

			wasteLevel -= wasteLevel;

		}
	}
}  