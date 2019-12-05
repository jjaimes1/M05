package veterinary;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ClinicTest {
	DateTimeFormatter formatterDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	Clinic c;

	@Before
	public void setUp() throws Exception {
		this.c = new Clinic();
	}

	// -------------------------------------------------------------------------------
	// Tests visitedAnimals
	// -------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------

	@Test
	public final void testVisitedAnimalsPets() {
		Animal a1 = new Pet(1, "Tara", "cat");
		Visit v1 = new VisitWithoutDiscount("13/12/2018", 'M');
		v1.setAnimal(a1);
		c.addVisit(v1);

		Animal a2 = new Pet(2, "Pluto", "dog");
		Visit v2 = new VisitWithoutDiscount("13/12/2018", 'A');
		v2.setAnimal(a2);
		c.addVisit(v2);

		HashSet<Animal> hs = new HashSet<Animal>();
		hs.add(a1);
		hs.add(a2);

		assertEquals(hs, c.visitedAnimals("pet"));
	}

	@Test
	public final void testVisitedAnimalsFarmAnimals() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		Visit v1 = new VisitWithoutDiscount("13/12/2018", 'D');
		v1.setAnimal(a1);
		c.addVisit(v1);

		Animal a2 = new FarmAnimal(2, "Nita", "horse");
		Visit v2 = new VisitWithoutDiscount("14/12/2018", 'D');
		v2.setAnimal(a2);
		c.addVisit(v2);

		HashSet<Animal> hs = new HashSet<Animal>();
		hs.add(a1);
		hs.add(a2);

		assertEquals(hs, c.visitedAnimals("farm"));
	}

	@Test
	public final void testVisitedAnimalsFutureDate() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		Visit v1 = new VisitWithoutDiscount("13/12/2019", 'D');
		v1.setAnimal(a1);
		c.addVisit(v1);

		Animal a2 = new FarmAnimal(2, "Nita", "horse");
		Visit v2 = new VisitWithoutDiscount("14/12/2019", 'D');
		v2.setAnimal(a2);
		c.addVisit(v2);

		assertEquals(null, c.visitedAnimals("farm"));
	}

	@Test
	public final void testVisitedAnimalsFarmAnimalsMixedVisits() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		Visit v1 = new VisitWithoutDiscount("14/12/2018", 'D');
		v1.setAnimal(a1);
		c.addVisit(v1);

		Animal a2 = new Pet(2, "Pluto", "dog");
		Visit v2 = new VisitWithoutDiscount("13/12/2018", 'A');
		v2.setAnimal(a2);
		c.addVisit(v2);

		HashSet<Animal> hs = new HashSet<Animal>();
		hs.add(a1);

		assertEquals(hs, c.visitedAnimals("farm"));
	}

	@Test
	public final void testVisitedAnimalsPetAnimalsMixedVisits() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		Visit v1 = new VisitWithoutDiscount("14/12/2018", 'D');
		v1.setAnimal(a1);
		c.addVisit(v1);

		Animal a2 = new Pet(2, "Pluto", "dog");
		Visit v2 = new VisitWithoutDiscount("13/12/2018", 'A');
		v2.setAnimal(a2);
		c.addVisit(v2);

		HashSet<Animal> hs = new HashSet<Animal>();
		hs.add(a2);

		assertEquals(hs, c.visitedAnimals("pet"));
	}

	// -------------------------------------------------------------------------------
	// Tests bookVisit
	// -------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------

	@Test
	public final void testBookVisitPetFirstVisit() {
		Animal a1 = new Pet(1, "Pluto", "dog");
		String tomorrow = LocalDate.now().plusDays(1).format(formatterDDMMYYYY);
		assertEquals(tomorrow + "-M", c.bookVisit(a1, false));
	}

	@Test
	public final void testBookVisitFarmFirstVisit() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		String tomorrow = LocalDate.now().plusDays(1).format(formatterDDMMYYYY);
		assertEquals(tomorrow + "-D", c.bookVisit(a1, false));
	}

	@Test
	public final void testBookVisitPetSecondVisitAfterPet() {
		Animal a1 = new Pet(1, "Pluto", "dog");
		String tomorrow = LocalDate.now().plusDays(1).format(formatterDDMMYYYY);
		assertEquals(tomorrow + "-M", c.bookVisit(a1, false));

		Animal a2 = new Pet(2, "Tara", "cat");
		assertEquals(tomorrow + "-A", c.bookVisit(a2, false));
	}

	@Test
	public final void testBookVisitPetSecondVisitAfterFarm() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		String tomorrow = LocalDate.now().plusDays(1).format(formatterDDMMYYYY);
		assertEquals(tomorrow + "-D", c.bookVisit(a1, false));
		
		String afterTomorrow = LocalDate.now().plusDays(2).format(formatterDDMMYYYY);
		Animal a2 = new Pet(2, "Tara", "cat");
		assertEquals(afterTomorrow + "-M", c.bookVisit(a2, false));
	}
	
	// -------------------------------------------------------------------------------
	// Tests profit
	// -------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------

	@Test
	public final void testProfitPastDates() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		Visit v1 = new VisitWithoutDiscount("14/12/2018", 'D');
		v1.setGrossPrice(100);
		v1.setAnimal(a1);
		c.addVisit(v1);

		Animal a2 = new Pet(2, "Pluto", "dog");
		Visit v2 = new VisitWithDiscount("13/12/2018", 'A');
		v2.setGrossPrice(100);
		v2.setAnimal(a2);
		c.addVisit(v2);

		assertEquals(229.9, c.profit("15/12/2018"), 0);
	}

	@Test
	public final void testProfitFutureDates() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		Visit v1 = new VisitWithoutDiscount("16/12/2018", 'D');
		v1.setGrossPrice(100);
		v1.setAnimal(a1);
		c.addVisit(v1);

		Animal a2 = new Pet(2, "Pluto", "dog");
		Visit v2 = new VisitWithDiscount("17/12/2018", 'A');
		v2.setGrossPrice(100);
		v2.setAnimal(a2);
		c.addVisit(v2);

		assertEquals(0, c.profit("15/12/2018"), 0);
	}

}
