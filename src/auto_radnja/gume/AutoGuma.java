package auto_radnja.gume;

/**
 * Predstavlja gumu automobila
 * 
 * @author ilijaradojkovic
 * @version 1.0
 *
 */
public class AutoGuma {
	/**
	 * Predstavlja marku modela gume
	 */
	private String markaModel = null;

	/**
	 * Predstavlja precnik gume
	 */
	private int precnik = -1;
	/**
	 * Predstavlja sirinu gume
	 */
	private int sirina = -1;
	/**
	 * Predstavlja visinu gume
	 */
	private int visina = -1;

	/**
	 * markaModel je null precnik je -1 sirina je -1 visina je -1
	 */
	public AutoGuma() {
	}

	/**
	 * 
	 * @param markaModel nova marka se postavlja
	 * @param precnik    novi precnik se postavlja
	 * @param sirina     nova sirina se postavlja
	 * @param visina     nova visina se postavlja
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * vraca marku modela gume
	 * 
	 * @return marka modela kao string
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * postavlja novu vrednost marke gume
	 * 
	 * @param markaModel nova marka modela gume
	 * @throws NullPointerException     ako je uneta marka null
	 * @throws IllegalArgumentException ako je duzina reci marke manja od 3
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * vraca precnik gume
	 * 
	 * @return precnik gume kao int
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * postavlja novu vrednost precnika gume
	 * 
	 * @param precnik novi precnik gume
	 * @throws IllegalArgumentException ako je precnik van opsega (13,22)
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * vraca sirinu gume
	 * 
	 * @return sirina gume kao int
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * postsavlja novu vrednost sirine gume
	 * 
	 * @param sirina nova sirina gume
	 * @throws IllegalArgumentException ako je sirina van opsega (135,355)
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * vraca visinu gume
	 * 
	 * @return visina gume kao int
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * postavlja novu vrednost visine gume
	 * 
	 * @param visina nova visina gume 
	 * @throws IllegalArgumentException ako je
	 *               visina van opsega (25,95)
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca sve podatke o gumi u jednom String-u.
	 * 
	 * @return String sa podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Uporedjuje dve gume po marci modela,precniku,sirini i visini
	 * 
	 * @param obj sa kojim uporedjujemo
	 * @return da li su objekti isti
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
