package org.wecancodeit;

public class VirtualPet implements Comparable<VirtualPet>{

	private static final int DEFAULT_PET_HEALTH = 10;
	private static final int DEFAULT_PET_HAPPINESS = 5;

	protected String petName;
	protected int petHealth = DEFAULT_PET_HEALTH;
	protected int petHappiness = DEFAULT_PET_HAPPINESS;
	protected String petDescription;
	protected PetBox petBox;

	public VirtualPet(String petName) {

		this.petName = petName;

	}

	public VirtualPet(String petName, String petDescription) {

		this.petName = petName;

		this.petDescription = petDescription;

	}
	
	public String getPetName() {

		return petName;

	}

	public int getHealth() {

		return petHealth;

	}

	public String getHealthStatus() { 

		String petHealthStatus;

		if (petHealth <= 0) {

			petHealthStatus = "DEAD";

		} else

			petHealthStatus =  Integer.toString(petHealth); {
			
			return petHealthStatus;
			}
		}


	public int getHappiness() {

		return petHappiness;

	}
	
	public String getPetDescription() {

		return petDescription;

	}
	
	public int getPetBoxID() {

		return petBox.getBoxID();

	}

	public int compareTo(VirtualPet s) {

		return petName.compareTo(s.getPetName());

	}

	public void assignBox(PetBox petBox) {

		this.petBox = petBox;

	}

	public void unAssignBox() {

		this.petBox = null;

	}

	public void tick() { 

	}

	public void play() {

		petHappiness ++;

	}
}