package interval_ir;

/**
 * Abstractetoestandsinvarianten:
 * 
 * @invar De ondergrens is niet groter dan de bovengrens.
 *     | getOndergrens() <= getBovengrens()
 * @invar De lengte is gelijk aan het verschil van de bovengrens en
 *       de ondergrens.
 *     | getLengte() == getBovengrens() - getOndergrens()
 */
public class Interval {
	/**
	 * Representatie-invariant:
	 * 
	 * @invar De lengte is niet negatief.
	 *     | 0 <= lengte
	 */
	private int ondergrens;
	private int lengte;

	public int getOndergrens() {
		return this.ondergrens;
	}
	
	public int getBovengrens() {
		return this.ondergrens + this.lengte;
	}
	
	public int getLengte() {
		return this.lengte;
	}
	
	/**
	 * @post | getOndergrens() == 0
	 * @post | getBovengrens() == 0
	 */
	public Interval() {}
	
	/**
	 * @throws IllegalArgumentException | ondergrens > bovengrens
	 * 
	 * @post | getOndergrens() == ondergrens
	 * @post | getBovengrens() == bovengrens
	 */
	public Interval(int ondergrens, int bovengrens) {
		if (ondergrens > bovengrens)
			throw new IllegalArgumentException("`ondergrens` is groter dan `bovengrens`");
		this.ondergrens = ondergrens;
		this.lengte = bovengrens - ondergrens;
	}
	
	/**
	 * Stelt de ondergrens in. Laat de bovengrens ongewijzigd.
	 * 
	 * @pre | waarde <= getBovengrens()
	 * 
	 * @post | getOndergrens() == waarde
	 * @post | getBovengrens() == old(getBovengrens())
	 */
	public void setOndergrens(int waarde) {
		this.ondergrens = waarde;
	}
	
	/**
	 * @pre | getOndergrens() <= waarde
	 * 
	 * @post | getBovengrens() == waarde
	 * @post | getOndergrens() == old(getOndergrens())
	 */
	public void setBovengrens(int waarde) {
		this.lengte = waarde - this.ondergrens;
	}
	
}
