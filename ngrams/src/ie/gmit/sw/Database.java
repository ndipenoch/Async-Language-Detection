package ie.gmit.sw;

import java.util.*;

/**
 * Create a TreeMap database. Each map in the database contain each of the 235
 * languages, with the kmers and frequency of occurrence.
 */
public class Database {

	// ---------------------------------------------------
	// Create a TreeMap database for the subject language.
	// ----------------------------------------------------
	protected static Map<Language, Map<Integer, LanguageEntry>> db = new TreeMap<>();

	// ------------------------------------------
	// Create a TreeSet containing the languages
	// with most frequencies in descending order.
	// -------------------------------------------
	static TreeSet<OutOfPlaceMetric> oopm = new TreeSet<>();

	// ---------------------------------------
	// Get the language with the most frequency
	// ----------------------------------------
	public String languageResult() {
		return oopm.first().getLanguage().toString();
	}

	
	/**
	 * Print to the screen the total number of Kmers and the total number of
	 * languages in the subject database.
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		int langCount = 0;
		int kmerCount = 0;
		Set<Language> keys = db.keySet();
		for (Language lang : keys) {
			langCount++;
			sb.append(lang.name() + "->\n");

			Collection<LanguageEntry> m = new TreeSet<>(db.get(lang).values());
			kmerCount += m.size();
			for (LanguageEntry le : m) {
				sb.append("\t" + le + "\n");
			}
		}
		sb.append(kmerCount + " total k-mers in " + langCount + " languages");
		return sb.toString();
	}
}