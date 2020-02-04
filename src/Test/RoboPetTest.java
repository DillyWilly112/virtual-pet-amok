package Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.Collection;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.wecancodeit.Cat;
import org.wecancodeit.Dog;
import org.wecancodeit.PetBox;
import org.wecancodeit.RoboCat;
import org.wecancodeit.RoboDog;
import org.wecancodeit.RoboPet;
import org.wecancodeit.VirtualPet;

public class RoboPetTest {
	
	PetBox testPetBox;
	VirtualPet testPet1;

	@Before
	public void setUp() {

		testPetBox = new PetBox(1);
		testPet1 = new VirtualPet("Bob");

	}

	@Test
	public void shouldAddRoboCat() {

		RoboCat roboCat1 = new RoboCat("Bytes");
		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(roboCat1);
		int petCountEnd = testPetBox.getSize();
		String petName = roboCat1.getPetName();
		assertEquals(petCountEnd -1, petCountStart);
		assertEquals(petName, "Bytes");

	}

	@Test
	public void shouldAddRoboDog() {

		RoboDog roboDog1 = new RoboDog("Copper");
		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(roboDog1);
		int petCountEnd = testPetBox.getSize();
		String petName = roboDog1.getPetName();
		assertEquals(petCountEnd -1, petCountStart);
		assertEquals(petName, "Copper");

	}

	@Test
	public void ShouldAddRoboDogAndRoboCat() {

		RoboCat roboCat1 = new RoboCat("Bytes");
		RoboDog roboDog1 = new RoboDog("Copper");
		testPetBox.addPet(roboCat1);
		testPetBox.addPet(roboDog1);
		assertThat(roboCat1, instanceOf(VirtualPet.class));
		assertThat(roboDog1, instanceOf(VirtualPet.class));

	}

	@Test
	public void shouldRemoveRoboPet() {

		RoboCat roboCat1 = new RoboCat("Bytes");
		RoboDog roboDog1 = new RoboDog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		testPetBox.addPet(roboDog2);
		testPetBox.addPet(roboCat2);
		testPetBox.addPet(roboDog1);
		testPetBox.addPet(roboCat1);
		testPetBox.removePet(roboDog1);
		Collection<VirtualPet> allPets = testPetBox.getAllPets();
		assertThat(allPets, not(contains(roboDog1)));

	}

	private Matcher contains(RoboDog roboDog1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void shouldDecreaseRustLevel() {

		RoboCat roboCat1 = new RoboCat("Bytes");
		roboCat1.oilPet();
		int rustLevelEnd = roboCat1.getPetRustLevel();
		assertEquals(rustLevelEnd, 0);

	}

	@Test
	public void shouldGeAllRobotPets() {

		Cat Cat1 = new Cat("Bytes");
		Dog Dog1 = new Dog("Copper");
		RoboCat roboCat2 = new RoboCat("Javi");
		RoboDog roboDog2 = new RoboDog("Trixie");
		testPetBox.addPet(roboDog2);
		testPetBox.addPet(roboCat2);
		testPetBox.addPet(Dog1);
		testPetBox.addPet(Cat1);
		Collection<RoboPet> robotPets = testPetBox.getAllRobotPets();
		assertThat(robotPets, not(containsInAnyOrder(Dog1, Cat1)));

	}

	private Matcher containsInAnyOrder(Dog dog1, Cat cat1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void shouldEffectRobotHealthHappinessRustWhenTickIsRun() {

		RoboCat roboCat = new RoboCat("Javi");
		testPetBox.addPet(roboCat);
		int catHappinessStart = roboCat.getHappiness();
		int catRustStart = roboCat.getPetRustLevel();
		int catHealthStart = roboCat.getHealth();
		roboCat.tick();
		assertEquals(catHappinessStart -1, 4);
		assertEquals(catRustStart + 1, 2);
		assertEquals(catHealthStart -1, 9);

	}
}
