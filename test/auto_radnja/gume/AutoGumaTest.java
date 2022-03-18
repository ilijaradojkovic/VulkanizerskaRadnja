package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import auto_radnja.gume.AutoGuma;

class AutoGumaTest {

	AutoGuma a;
	@BeforeEach
	void setUp() throws Exception {
		a=new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	@Test
	void testAutoGuma() {
		AutoGuma g=new AutoGuma();
		assertTrue(g.getMarkaModel()==null);
		assertTrue(g.getPrecnik()==-1);
		assertTrue(g.getSirina()==-1);
		assertTrue(g.getVisina()==-1);
	}
	@Test
	void testAutoGuma_SaParametrima() {
		AutoGuma g=new AutoGuma("Marka1",15,200,70);
		assertTrue(g.getMarkaModel().equals("Marka1"));
		assertTrue(g.getPrecnik()==15);
		assertTrue(g.getSirina()==200);
		assertTrue(g.getVisina()==70);
	}

	
	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("Marka");
		assertEquals("Marka", a.getMarkaModel());
	}

	@Test
	void testSetMarkaModel_Null() {
	
		assertThrows(NullPointerException.class, ()->	a.setMarkaModel(null));
	}


	@Test
	void testSetMarkaModel_DuzinaFails() {
	
		assertThrows(IllegalArgumentException.class, ()->	a.setMarkaModel("f"));
	}

	@ParameterizedTest
	@CsvSource({
		"15", "19", "20"
	})
	
	void testSetPrecnik() {
		a.setPrecnik(15);
		assertEquals(15, a.getPrecnik());
	}

	@ParameterizedTest
	@CsvSource({
		"11", "2", "8"
	})
	void testSetPrecnik_DonjiOpsegFails() {
		assertThrows(IllegalArgumentException.class, ()->	a.setPrecnik(23));
		

	}

	@ParameterizedTest
	@CsvSource({
		"25", "40", "60"
	})
	void testSetPrecnik_GornjiOpsegFails() {
		assertThrows(IllegalArgumentException.class, ()->	a.setPrecnik(23));


	}
	@ParameterizedTest
	@CsvSource({
		"150", "190", "250"
	})
	void testSetSirina() {
		a.setSirina(200);
		assertEquals(200, a.getSirina());
	}

	@ParameterizedTest
	@CsvSource({
		"50", "45", "60"
	})
	void testSetSirina_DonjiOpsegFail() {
		assertThrows(IllegalArgumentException.class, ()->	a.setSirina(134));
		
	}


	@ParameterizedTest
	@CsvSource({
		"400", "500", "390"
	})
	void testSetSirina_GornjiOpsegFail() {
		assertThrows(IllegalArgumentException.class, ()->	a.setSirina(134));
		
	}

	@ParameterizedTest
	@CsvSource({
		"50", "45", "60"
	})
	
	void testSetVisina(int visina) {
		a.setVisina(visina);
		assertEquals(visina,a.getVisina());
	}

	@ParameterizedTest
	@CsvSource({
		"100", "200", "130"
	})

	void testSetVisina_GornjiOpsegFail(int visina) {
		
		assertThrows(IllegalArgumentException.class, ()->	a.setVisina(visina));
	}
	

	@ParameterizedTest
	@CsvSource({
		"20", "13", "9"
	})
	void testSetVisina_DonjiOpsegFail(int visina) {
		
		assertThrows(IllegalArgumentException.class, ()->	a.setVisina(visina));
	}

	@Test
	void testToString() {
AutoGuma a1 = new AutoGuma("Marka",15,200,70);
	
		
		
		
		
		String s = a1.toString();
		assertTrue(s.contains("Marka"),"toString ne sadrzi marku");
		assertTrue(s.contains("15"),"toString ne sadrzi precnik");
		assertTrue(s.contains("200"),"toString ne sadrzi sirinu");
		assertTrue(s.contains("70"),"toString ne sadrzi visinu");
	}

	@ParameterizedTest
	@CsvSource({
		
		"Marka, 15, 200, 70, Marka, 15, 200, 70, true ",
		"Marka, 15, 200, 70, Markaa, 15, 200, 70, true ",
		"Marka, 17, 200, 70, Marka, 15, 200, 80, false ",
		"Marka, 15, 201, 70, Marka, 15, 200, 80, false ",
		"Marka, 15, 200, 70, Marka, 15, 200, 80, false ",
	})
	void testEqualsObject(String markaPrvog,int precnikPrvog,int sirinaPrvog,int visinaPrvog,String markaDrugog,int precnikDrugog,int sirinaDrugog,int visinaDrugog,boolean result) {
		AutoGuma a1 = new AutoGuma(markaPrvog,precnikPrvog,sirinaPrvog,visinaPrvog);
		a.setMarkaModel(markaDrugog);
		a.setPrecnik(precnikDrugog);
		a.setSirina(sirinaDrugog);
		a.setVisina(visinaDrugog);
	
		assertEquals(result, a.equals(a1));
	}

}
