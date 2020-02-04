package Test;

import static org.junit.Assert.assertEquals;



import org.junit.Before;

import org.junit.Test;
import org.wecancodeit.PetBox;
import org.wecancodeit.RoboPet;
import org.wecancodeit.VirtualPet;



public class VirtualPetTest {

	

	PetBox testPetBox;

	VirtualPet testPet1;

	

	@Before
	public void setUp() {

		testPetBox = new PetBox(1);
		testPet1 = new VirtualPet("Bob");

	}

	@Test
	public void shouldAddPet() {

		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(testPet1);
		int petCountEnd = testPetBox.getSize();
		String petName = testPet1.getPetName();
		assertEquals(petCountEnd - 1, petCountStart);
		assertEquals(petName, "Bob" );

	}

	@Test
	public void shouldReturnHealth() {

		testPetBox.addPet(testPet1);
		int petHealth = testPet1.getHealth();
		assertEquals(petHealth, 10);

	}

	@Test
	public void shouldReturnHappiness() {

		testPetBox.addPet(testPet1);
		int petHappy = testPet1.getHappiness();
		assertEquals(petHappy, 5);

	}

	@Test
	public void shouldAddRoboPet() {
		
		RoboPet roboPet = new RoboPet("Copper");
		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(roboPet);
		int petCountEnd = testPetBox.getSize();
		String petName = roboPet.getPetName();
		assertEquals(petCountEnd -1, petCountStart);
		assertEquals(petName, "Copper");

	}

	@Test
	public void shouldAddTwoRoboPet() {

		RoboPet roboPet1 = new RoboPet("Copper");
		RoboPet roboPet2 = new RoboPet("Bytes");
		testPetBox.addPet(roboPet1);
		testPetBox.addPet(roboPet2);
		int petCountStart = testPetBox.getSize();
		assertEquals(petCountStart, 2);

	}

	@Test
	public void shouldReturnRustLevel() {

	RoboPet roboPet = new RoboPet("Copper");

	testPetBox.addPet(roboPet);
	int petRustLevel = roboPet.getPetRustLevel();
	assertEquals(petRustLevel, 1);

	}

	@Test
	public void shouldReturnRobotHappiness() {

		RoboPet roboPet1 = new RoboPet("Copper");
		testPetBox.addPet(roboPet1);
		int petHappiness1 = roboPet1.getHappiness();
		assertEquals(petHappiness1, 5);		

	}
}
