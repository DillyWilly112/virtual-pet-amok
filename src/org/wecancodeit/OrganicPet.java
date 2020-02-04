package org.wecancodeit;

public class OrganicPet extends VirtualPet{

	private static final int DEFAULT_THIRST_LEVEL = 1;
	private static final int DEFAULT_HUNGER_LEVEL = 1;
	private static final int DEFAULT_WASTE_LEVEL = 1;

	protected int wasteLevel = DEFAULT_WASTE_LEVEL;
	protected int hungerLevel = DEFAULT_HUNGER_LEVEL;
	protected int thirstLevel = DEFAULT_THIRST_LEVEL;

	public OrganicPet(String petName) {

		super(petName);

	}

	public OrganicPet(String petName, String petDescription) {

		super(petName);

		this.petDescription = petDescription;

	}

	public int getWasteLevel() {

		return wasteLevel ;

	}

	public int getHungerLevel() {

		return hungerLevel ;

	}

	public int getThirstLevel() {

		return thirstLevel ;

	}

	public void feedPet() {

		hungerLevel -=2;
		thirstLevel ++;
		wasteLevel += 2;
		petHappiness ++;

	}

	public void waterPet() {

		thirstLevel -= thirstLevel;
		wasteLevel += 2;
		petHappiness ++;

	}
}

