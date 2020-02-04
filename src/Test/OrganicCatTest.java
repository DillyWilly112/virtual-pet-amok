package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.wecancodeit.Cat;
import org.wecancodeit.LitterBox;
import org.wecancodeit.OrganicPet;
import org.wecancodeit.PetBox;
import org.wecancodeit.VirtualPet;

public class OrganicCatTest {

	LitterBox testLitterBox;
	Cat testCat;
	OrganicPet organicPet;
	PetBox petBox;

	@Before
	public void setUp() {

		testLitterBox = new LitterBox(1);
		testCat = new Cat("Fluffy");
		organicPet = new OrganicPet("Rock");
		petBox = new PetBox(1);

	}
	
	@Test
	public void shouldAddOrganicPetToPetBox() {

		petBox.addPet(organicPet);
		Collection<VirtualPet> checkPets = petBox.getAllPets();
		assertThat(checkPets, contains(organicPet));

	}

	private Matcher contains(OrganicPet organicPet2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void shouldGetOrganicPetWaste() {

		petBox.addPet(organicPet);
		int petWasteLevel = organicPet.getWasteLevel();
		assertEquals(petWasteLevel, 1);

	}

	@Test
	public void shouldGetOrganicPetHunger() {

		petBox.addPet(organicPet);
		int petHunger = organicPet.getHungerLevel();
		assertEquals(petHunger, 1);

	}

	@Test
	public void shouldGetOrganicPetThirst() {

		petBox.addPet(organicPet);
		int petThirst = organicPet.getThirstLevel();
		assertEquals(petThirst, 1);

	}

	@Test
	public void shouldAddCatToLitterBox() {

		testLitterBox.addPet(testCat);
		Collection<VirtualPet> checkPets = testLitterBox.getAllPets();
		assertThat(checkPets, contains(testCat));

	}

	@Test
	public void shouldGetCatWasteLevel() {

		testLitterBox.addPet(testCat);
		int wasteLevel = testCat.getWasteLevel();
		assertEquals(wasteLevel, 1);

	}

	@Test
	public void shouldGetCatBoredomLevel() {

		petBox.addPet(testCat);
		int catBoredomLevel = testCat.getHappiness();
		assertEquals(catBoredomLevel, 5);

	}

	@Test
	public void shouldEffectCatHungerHappinessThirstWhenTickIsRun() {

		petBox.addPet(testCat);
		int catHungerStart = testCat.getHungerLevel();
		int catHappinessStart = testCat.getHappiness();
		int catThirstStart = testCat.getThirstLevel();
		testCat.tick();
		assertEquals(catHungerStart + 1, 2);
		assertEquals(catHappinessStart -1, 4);
		assertEquals(catThirstStart + 1, 2);

	}
}
