package org.wecancodeit;

public class RoboDog extends RoboPet implements DogWalk {

	public RoboDog(String petName) {

		super(petName);

	}

	public RoboDog(String petName, String petDescription) {

		super(petName);

		this.petDescription = petDescription;

	}

	@Override
	public void takeForWalk() {

		petHappiness += 2; 

	}
}
