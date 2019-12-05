package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import veterinary.*;

public class ClinicTest {
	DateTimeFormatter formatterDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	Clinic c;

	@Before
	public void setUp() throws Exception {
		this.c = new Clinic();
	}

	//cuando no tiene descuento se le aplica 21% a precio bruto
    //si tiene descuento se le resta 15% del preco bruto (julio o agosto)
        //si es otro mes cualquiera y tiene descuento, una resta 10% del precio bruto
        //luego se le aplica a ambos el IVA del 21%
	@Test
    public void testDescuentos()
    {
        char torn = 'M';
		String iLletra= "";
		for (int i = 1; i <= 31; i++)
		{
			if (i <10)
			{
				iLletra ="0"+String.valueOf(i);
			}
			else {
				iLletra = String.valueOf(i);
			}
				Visit visitDescSum = new VisitWithDiscount( iLletra+ "/07/2019", torn);

			visitDescSum.setGrossPrice(100);
			assertEquals(102.85, visitDescSum.calculateCost(), 0);
		}
		for (int i = 1; i <= 30; i++)
		{
			if (i <10)
			{
				iLletra ="0"+String.valueOf(i);
			}
			else {
				iLletra = String.valueOf(i);
			}
			Visit visit = new VisitWithoutDiscount( iLletra+ "/11/2019", torn);
			Visit visitDesc = new VisitWithDiscount( iLletra+ "/11/2019", torn);

			visit.setGrossPrice(100);
			visitDesc.setGrossPrice(100);
			assertEquals(121, visit.calculateCost(), 0);
			assertEquals(108.9, visitDesc.calculateCost(), 0);
		}


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
		String tomorrow2 = "";
		for (int i = 1; i <=30 - LocalDateTime.now().getDayOfMonth(); i++)
		{
			tomorrow2 = LocalDate.now().plusDays(i).format(formatterDDMMYYYY);
			assertEquals(tomorrow2 + "-M", c.bookVisit(a1, false));
			assertEquals(tomorrow2 + "-A", c.bookVisit(a1, false));
		}

	}

	@Test
	public final void testBookVisitFarmFirstVisit() {
		Animal a1 = new FarmAnimal(1, "Blanca", "cow");
		String tomorrow = "";
		for (int i = 1; i <=30 - LocalDateTime.now().getDayOfMonth(); i++)
		{
			tomorrow = LocalDate.now().plusDays(i).format(formatterDDMMYYYY);
			assertEquals(tomorrow + "-D", c.bookVisit(a1, false));
		}

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
