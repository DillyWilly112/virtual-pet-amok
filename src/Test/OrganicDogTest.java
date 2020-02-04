package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.wecancodeit.Cage;
import org.wecancodeit.Dog;
import org.wecancodeit.VirtualPet;

public class OrganicDogTest {

	Cage testCage;
	Dog testDog;

	@Before
	public void setUp() {

		testCage = new Cage(1);
		testDog = new Dog("Rover");

	}

	@Test
	public void shouldAddDogToCage() {

		testCage.addPet(testDog);
		Collection<VirtualPet> checkPets = testCage.getAllPets();
		assertThat(checkPets, contains(testDog));

	}

	private Matcher contains(Dog testDog2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void shouldGetDogWasteLevel() {

		testCage.addPet(testDog);
		int wasteLevel = testDog.getWasteLevel();
		assertEquals(wasteLevel, 1);

	}

	@Test
	public void shouldReduceWasteAfterWalk() {

		int wasteLevelStart = testDog.getWasteLevel();
		testDog.takeForWalk();
		int wasteLevelEnd = testDog.getWasteLevel();
		assertEquals(wasteLevelStart - 1, wasteLevelEnd);

	}

	@Test
	public void shouldEffectDogHungerHappinessThirstWhenTickIsRun() {

		testCage.addPet(testDog);
		int dogHungerStart = testDog.getHungerLevel();
		int dogHappinessStart = testDog.getHappiness();
		int dogThirstStart = testDog.getThirstLevel();
		testDog.tick();
		assertEquals(dogHungerStart + 1, 2);
		assertEquals(dogHappinessStart -1, 4);
		assertEquals(dogThirstStart + 1, 2);

	}
}