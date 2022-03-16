package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja interfejs radnje
 * 
 * @author ilijaradojkovic
 * @version 1.0
 *
 */
public interface Radnja {
	/**
	 * 
	 * Dodaje AutoGumu u listu
	 * @param a AutoGuma koja se dodaje 
	 * @throws NullPointerException ako je Autoguma  null
	 * @throws RuntimeException ako Autoguma vec postoji
	 */
	void dodajGumu(AutoGuma a);
	/**
	 * Pretrazuje gume po marci 
	 * @param markaModel marka po kojoj se pretrazuje
	 * @return listu guma
	 *
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * 
	 * @return vraca sve gume
	 */
	List<AutoGuma> vratiSveGume();
}
