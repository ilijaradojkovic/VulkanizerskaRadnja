package test.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import auto_radnja.Radnja;
import auto_radnja.gume.AutoGuma;

abstract class RadnjaTest {

	
	protected Radnja r;
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDodajGumu() {
		AutoGuma guma=new AutoGuma("Marka", 15, 200, 70);
		r.dodajGumu(guma);
		assertEquals(1, r.vratiSveGume().size());
		assertEquals(guma, r.vratiSveGume().get(0));
	}

	@Test
	void testDodajViseGuma() {
		AutoGuma guma=new AutoGuma("Marka", 15, 200, 70);
		r.dodajGumu(guma);
		assertEquals(1, r.vratiSveGume().size());
		AutoGuma guma1=new AutoGuma("Marka", 16, 201, 71);
		r.dodajGumu(guma1);
		assertEquals(2, r.vratiSveGume().size());
		
		assertEquals(guma, r.vratiSveGume().get(0));
		assertEquals(guma1, r.vratiSveGume().get(1));
	}
	@Test
	void testDodajGumu_Duplikat() {
		AutoGuma guma=new AutoGuma("Marka", 15, 200, 70);
		r.dodajGumu(guma);
	
	
		assertThrows(RuntimeException.class, ()->r.dodajGumu(guma));
	}

@Test
void testDodajGumu_Null() {
	AutoGuma guma=null;


	assertThrows(NullPointerException.class, ()->r.dodajGumu(guma));
}


	
	
	@Test
	void testPronadjiGumu_MarkaModelNull() {
		AutoGuma g=new AutoGuma();
		assertNull(r.pronadjiGumu(g.getMarkaModel()));
	}
	

	@Test
	void testPronadjiGumu_NemaIsitih() {
		AutoGuma guma=new AutoGuma("Marka", 15, 200, 70);
		r.dodajGumu(guma);
		AutoGuma guma1=new AutoGuma("Marka1", 16, 201, 71);
		r.dodajGumu(guma1);
		assertEquals(0, r.pronadjiGumu("feqr").size());
	}
	@Test
	void testPronadjiGumu_Pronadjeno() {
		AutoGuma guma=new AutoGuma("Marka", 15, 200, 70);
		r.dodajGumu(guma);
		AutoGuma guma1=new AutoGuma("Marka", 16, 201, 71);
		r.dodajGumu(guma1);
		assertEquals(2, r.pronadjiGumu("Marka").size());
	}
	
	@Test
	void testVratiSveGume() {
		AutoGuma guma=new AutoGuma("Marka", 15, 200, 70);
		r.dodajGumu(guma);
		AutoGuma guma1=new AutoGuma("Marka1", 16, 201, 71);
		r.dodajGumu(guma1);
		AutoGuma guma2=new AutoGuma("Marka2", 17, 202, 72);
		r.dodajGumu(guma2);
		assertEquals(3, r.vratiSveGume().size());
		assertAll(()->assertTrue(r.vratiSveGume().contains(guma)),
				()->assertTrue(r.vratiSveGume().contains(guma1)),
				()->assertTrue(r.vratiSveGume().contains(guma2))
				);
	}

}
