package org.wecancodeit;

public class Dog extends OrganicPet implements DogWalk {

	public Dog(String petName) {

		super(petName);

	}

	public Dog(String petName, String petDescription) {

		super(petName);

		this.petDescription = petDescription;

	}

	@Override
	public void takeForWalk() {

		wasteLevel -= wasteLevel;
		petHappiness += 2; 

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
