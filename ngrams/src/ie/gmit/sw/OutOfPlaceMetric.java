package ie.gmit.sw;

/**
 * Create a query language object that that have 2 parameters. Get the absolute
 * distance in case it is a negative value. Order the the distance in an
 * ascending order.
 */
public class OutOfPlaceMetric implements Comparable<OutOfPlaceMetric> {
	private Language lang;
	private int distance;

	// Constructor that takes 2 parameters.
	public OutOfPlaceMetric(Language lang, int distance) {
		super();
		this.lang = lang;
		this.distance = distance;
	}

	// Get the language
	public Language getLanguage() {
		return lang;
	}

	// Get the absolute distance
	public int getAbsoluteDistance() {
		return Math.abs(distance);
	}

	// order the distance in an ascending order
	// the closest one to zero will be at the top.
	@Override
	public int compareTo(OutOfPlaceMetric o) {
		return Integer.compare(this.getAbsoluteDistance(), o.getAbsoluteDistance());
	}

	@Override
	public String toString() {
		return "[lang=" + lang + ", distance=" + getAbsoluteDistance() + "]";
	}

}
