package Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.wecancodeit.Cage;

public class CageTest {
	
	Cage cageTest;

	@Before
	public void setUp() {

		cageTest = new Cage(1);

	}

	@Test
	public void shouldHaveDirtyValueAfterMakeDirty() {

		int cageDirtyStart = cageTest.getCleanliness();
		cageTest.makePetBoxDirty(1);
		int cageDirtyEnd = cageTest.getCleanliness();
		assertEquals(cageDirtyStart + 1, cageDirtyEnd);

	}

	@Test
	public void shouldCleanPetBox() {

		cageTest.makePetBoxDirty(1);
		int cageDirtyStart = cageTest.getCleanliness();
		cageTest.scrubPetBox();
		int cageDirtyEnd = cageTest.getCleanliness();
		assertEquals(cageDirtyStart - 1, cageDirtyEnd);

	}
}
